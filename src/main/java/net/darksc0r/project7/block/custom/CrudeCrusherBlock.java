package net.darksc0r.project7.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class CrudeCrusherBlock extends HorizontalDirectionalBlock {
    // makes the block have a direction so it places in the correct spot
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    // Need this for save/loading thingy
    public static final MapCodec<CrudeCrusherBlock> CODEC = simpleCodec(CrudeCrusherBlock::new);

    /*
    FOR FUTURE USE
    WHEN I NEED AN ITEM TO BE PASSED THROUGH TO GET ANOTHER ITEM.
    if(isValidItem(itemEntity.getItem())) {}

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.CRUSHABLE_ITEMS);
    {
     */
    @Override
    public MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.project7.crude_crusher.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public CrudeCrusherBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));

    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        // Placeholder: a simple full cube shape for now
        return Block.box(0, 0, 0, 16, 16, 16);
    }
}
