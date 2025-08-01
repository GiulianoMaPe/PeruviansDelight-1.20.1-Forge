package net.giuliano.peruviansdelight.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
            ForgeRegistries.ITEMS.getCodec().optionalFieldOf("item").forGetter(m -> Optional.ofNullable(m.item))
    ).apply(inst, AddItemModifier::new)));

    @Nullable
    private final Item item;

    public AddItemModifier(LootItemCondition[] conditionsIn, Optional<Item> item) {
        super(conditionsIn);
        this.item = item.orElse(null);
    }
    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        this(conditionsIn, Optional.of(item));
    }
    public AddItemModifier(LootItemCondition[] conditionsIn) {
        this(conditionsIn, Optional.empty());
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (this.item != null) {
            generatedLoot.add(new ItemStack(this.item));
        } else {
            if (context.hasParam(LootContextParams.THIS_ENTITY) && context.getParam(LootContextParams.THIS_ENTITY) instanceof Llama llama) {
                Item woolItem = getWoolForVariant(llama.getVariant());
                if (woolItem != null) {
                    generatedLoot.add(new ItemStack(woolItem, 1));
                }
            }
        }

        return generatedLoot;
    }

    private static Item getWoolForVariant(Llama.Variant variant) {
        return switch (variant) {
            case CREAMY, WHITE -> Blocks.WHITE_WOOL.asItem();
            case BROWN -> Blocks.BROWN_WOOL.asItem();
            case GRAY -> Blocks.GRAY_WOOL.asItem();
            default -> null;
        };
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
