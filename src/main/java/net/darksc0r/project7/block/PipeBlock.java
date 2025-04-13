package net.darksc0r.project7.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PipeBlock extends Block {
//    public static final BooleanProperty PIPE_NORTH = BooleanProperty.create("north");
//    public static final BooleanProperty PIPE_SOUTH = BooleanProperty.create("south");
//    public static final BooleanProperty PIPE_EAST = BooleanProperty.create("east");
//    public static final BooleanProperty PIPE_WEST = BooleanProperty.create("west");

    public PipeBlock(Properties properties) {
        super(properties);
//        this.registerDefaultState(this.stateDefinition.any()
//                .setValue(PIPE_NORTH, false)
//                .setValue(PIPE_SOUTH, false)
//                .setValue(PIPE_EAST, false)
//                .setValue(PIPE_WEST, false)
//        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Shapes.box(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);
    }

//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext context) {
//        BlockState state = super.getStateForPlacement(context);
//        BlockPos pos = context.getClickedPos();
//        BlockGetter world = context.getLevel();
//
//        // Check adjacent blocks and set state accordingly
//        boolean north = world.getBlockState(pos.north()).getBlock() == this;
//        boolean south = world.getBlockState(pos.south()).getBlock() == this;
//        boolean east = world.getBlockState(pos.east()).getBlock() == this;
//        boolean west = world.getBlockState(pos.west()).getBlock() == this;
//
//        // Custom property to track pipe connections
//        return state.setValue(PIPE_NORTH, north).setValue(PIPE_SOUTH, south)
//                .setValue(PIPE_EAST, east).setValue(PIPE_WEST, west);
//    }

}
