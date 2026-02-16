package net.giuliano.peruviansdelight.block.entity;

import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TendalBlockEntity extends BlockEntity {
    // Definición del inventario con lógica de tolvas (extraer solo procesados)
    public final ItemStackHandler inventory = new ItemStackHandler(9) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
                // Resetear progreso si cambia el item manualmente
                progress[slot] = 0;
                maxProgress[slot] = 0;
            }
        }

        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            ItemStack stack = this.getStackInSlot(slot);
            if (level != null && !stack.isEmpty()) {
                // Verificar si tiene receta (es decir, si todavía se está secando)
                Optional<TendalRecipe> recipe = level.getRecipeManager().getAllRecipesFor(ModRecipes.TENDAL_TYPE.get())
                        .stream()
                        .filter(r -> r.input.test(stack))
                        .findFirst();

                // Si tiene receta, la tolva NO puede sacarlo
                if (recipe.isPresent()) {
                    return ItemStack.EMPTY;
                }
            }
            return super.extractItem(slot, amount, simulate);
        }
    };

    // Capability para 1.20.1
    private final LazyOptional<IItemHandler> inventoryOptional = LazyOptional.of(() -> this.inventory);

    private final int[] progress = new int[9];
    private final int[] maxProgress = new int[9];

    public TendalBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TENDAL_BE.get(), pos, blockState);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return inventoryOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inventoryOptional.invalidate();
    }

    public void drops() {
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            container.setItem(i, inventory.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, container);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", inventory.serializeNBT());
        pTag.putIntArray("progress", progress);
        pTag.putIntArray("maxProgress", maxProgress);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        inventory.deserializeNBT(pTag.getCompound("inventory"));
        int[] loadedProgress = pTag.getIntArray("progress");
        if (loadedProgress.length == 9) System.arraycopy(loadedProgress, 0, progress, 0, 9);
        int[] loadedMax = pTag.getIntArray("maxProgress");
        if (loadedMax.length == 9) System.arraycopy(loadedMax, 0, maxProgress, 0, 9);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, TendalBlockEntity entity) {
        if (level.isClientSide) return;

        // Condiciones ambientales
        boolean esDeDia = level.isDay();
        boolean sinSombra = level.canSeeSky(pos.above());
        boolean estaLloviendo = level.isRainingAt(pos.above());

        if (!esDeDia || !sinSombra || estaLloviendo) {
            return;
        }

        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            ItemStack stack = entity.inventory.getStackInSlot(i);

            if (!stack.isEmpty()) {
                if (entity.maxProgress[i] <= 0) {
                    Optional<TendalRecipe> recipe = level.getRecipeManager().getAllRecipesFor(ModRecipes.TENDAL_TYPE.get())
                            .stream()
                            .filter(r -> r.input.test(stack))
                            .findFirst();

                    if (recipe.isPresent()) {
                        entity.maxProgress[i] = recipe.get().time;
                    } else {
                        entity.progress[i] = 0;
                        continue;
                    }
                }

                entity.progress[i]++;

                if (entity.progress[i] >= entity.maxProgress[i]) {
                    craftItem(level, pos, entity, i);
                }
            } else {
                entity.progress[i] = 0;
                entity.maxProgress[i] = 0;
            }
        }
    }

    private static void craftItem(Level level, BlockPos pos, TendalBlockEntity entity, int slot) {
        ItemStack stack = entity.inventory.getStackInSlot(slot);

        Optional<TendalRecipe> recipe = level.getRecipeManager().getAllRecipesFor(ModRecipes.TENDAL_TYPE.get())
                .stream()
                .filter(r -> r.input.test(stack))
                .findFirst();

        if (recipe.isPresent()) {
            ItemStack output = recipe.get().output.copy();
            entity.inventory.setStackInSlot(slot, output);
            entity.progress[slot] = 0;
            entity.maxProgress[slot] = 0;
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}