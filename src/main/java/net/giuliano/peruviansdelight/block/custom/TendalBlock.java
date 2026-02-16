package net.giuliano.peruviansdelight.block.custom;

import net.giuliano.peruviansdelight.block.entity.ModBlockEntities;
import net.giuliano.peruviansdelight.block.entity.TendalBlockEntity;
import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TendalBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 9, 16);

    public TendalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TendalBlockEntity(pos, state);
    }

    // --- INTERACCIÓN (FORGE 1.20.1) ---
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        // Evitar que se ejecute dos veces (una por cada mano)
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TendalBlockEntity tendal) {
            ItemStack heldItem = player.getMainHandItem();

            if (heldItem.isEmpty()) {
                // Mano vacía: Sacar ítem
                extractLastItem(tendal, player);
                return InteractionResult.CONSUME;
            } else {
                // Mano con ítem: Intentar meter
                insertItem(tendal, player, heldItem);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }

    private void insertItem(TendalBlockEntity be, Player player, ItemStack stack) {
        Level level = be.getLevel();
        if (level == null) return;

        // Verificar receta (1.20.1 usa SimpleContainer para chequear recetas manuales usualmente)
        // Aquí simulamos un container temporal para verificar
        boolean hasRecipe = false;

        // Buscamos manualmente si existe una receta que acepte este item
        // Nota: En 1.20.1 el RecipeManager funciona un poco distinto, iteramos las recetas.
        Optional<TendalRecipe> recipe = level.getRecipeManager().getAllRecipesFor(ModRecipes.TENDAL_TYPE.get())
                .stream()
                .filter(r -> r.input.test(stack))
                .findFirst();

        if (recipe.isEmpty()) {
            player.displayClientMessage(Component.translatable("message.peruviansdelight.cannot_dry"), true);
            return;
        }

        for (int i = 0; i < be.inventory.getSlots(); i++) {
            if (be.inventory.getStackInSlot(i).isEmpty()) {
                be.inventory.insertItem(i, stack.copyWithCount(1), false);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                return;
            }
        }
    }

    private void extractLastItem(TendalBlockEntity be, Player player) {
        for (int i = be.inventory.getSlots() - 1; i >= 0; i--) {
            ItemStack stack = be.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                player.getInventory().add(stack);
                be.inventory.setStackInSlot(i, ItemStack.EMPTY);
                return;
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TendalBlockEntity be) {
                // Dropear items
                be.drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // En 1.20.1 se usa esta validación estándar
        if (level.isClientSide()) {
            return null;
        }
        return createTickerHelper(type, ModBlockEntities.TENDAL_BE.get(), TendalBlockEntity::tick);
    }
}