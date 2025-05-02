package net.darksc0r.project7.block.entity;

import net.darksc0r.project7.block.custom.CrudeKilnBlock;
import net.darksc0r.project7.registry.ModItems;
import net.darksc0r.project7.screen.custom.CrudeKilnMenu;
import net.darksc0r.project7.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class CrudeKilnBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 4);
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int FUEL_SLOT = 2;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 152;
    private int litTime = 0;
    private int litDuration = 0;

    public CrudeKilnBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.CRUDE_KILN_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> CrudeKilnBlockEntity.this.progress;
                    case 1 -> CrudeKilnBlockEntity.this.maxProgress;
                    case 2 -> CrudeKilnBlockEntity.this.litTime;
                    case 3 -> CrudeKilnBlockEntity.this.litDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> CrudeKilnBlockEntity.this.progress = value;
                    case 1 -> CrudeKilnBlockEntity.this.maxProgress = value;
                    case 2 -> CrudeKilnBlockEntity.this.litTime = value;
                    case 3 -> CrudeKilnBlockEntity.this.litDuration = value;
                }
            }

            @Override
            public int getCount() {
                return 4; // <--- IMPORTANT!
            }
        };
    }

    // Sets the name
    @Override
    public Component getDisplayName() {
        return Component.translatable("block.project7.crude_kiln");
    }

    // Adds a custom tooltip to the Item
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CrudeKilnMenu(i, inventory, this, this.data);
    }

    // Makes the item drop its self
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        boolean wasLit = isLit();
        boolean dirty = false;

        if (isLit()) {
            litTime--;
        }

        if (hasRecipe()) {
            if (!isLit() && hasFuel()) {
                consumeFuel();
                dirty = true;
            }

            if (isLit()) {
                increaseSmeltingProgress();

                if (hasSmeltingFinished()) {
                    smeltItem();
                    resetProgress();
                    dirty = true;
                }
            } else {
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (wasLit != isLit()) {
            dirty = true;
            level.setBlock(blockPos, blockState.setValue(CrudeKilnBlock.LIT, isLit()), 3);
        }

        if (dirty) {
            setChanged(level, blockPos, blockState);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("crude_kiln.progress", progress);
        pTag.putInt("crude_kiln.max_progress", maxProgress);
        pTag.putInt("crude_kiln.lit_time", litTime);
        pTag.putInt("crude_kiln.lit_duration", litDuration);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("crude_kiln.progress");
        maxProgress = pTag.getInt("crude_kiln.max_progress");
        litTime = pTag.getInt("crude_kiln.lit_time");
        litDuration = pTag.getInt("crude_kiln.lit_duration");
    }

    private boolean isLit() {
        return litTime > 0;
    }

    private void consumeFuel() {
        ItemStack fuelStack = itemHandler.getStackInSlot(FUEL_SLOT);
        int burnTime = getBurnTime(fuelStack);

        if (burnTime > 0) {
            litTime = burnTime;
            litDuration = burnTime;

            fuelStack.shrink(1);
        }
    }

    private int getBurnTime(ItemStack stack) {
        return net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity.getFuel().getOrDefault(stack.getItem(), 0);
    }

    private boolean isFuel(ItemStack stack) {
        return getBurnTime(stack) > 0;
    }


    private boolean hasFuel() {
        ItemStack fuelStack = itemHandler.getStackInSlot(FUEL_SLOT);
        return !fuelStack.isEmpty() && isFuel(fuelStack);
    }

    private void smeltItem() {
        ItemStack output = new ItemStack(ModItems.TIN.get(), 1);

        itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));

        // add this field to the class
        boolean hasConsumedFuel = false; // 🔥 Reset fuel for the next recipe
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 152;
    }

    private boolean hasSmeltingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseSmeltingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack output = new ItemStack(ModItems.TIN.get(), 1);

        return itemHandler.getStackInSlot(INPUT_SLOT).is(ModItems.RAW_TIN) &&
                canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
