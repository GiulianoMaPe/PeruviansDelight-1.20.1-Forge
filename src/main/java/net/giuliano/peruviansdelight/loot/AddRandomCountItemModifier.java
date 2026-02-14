package net.giuliano.peruviansdelight.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddRandomCountItemModifier extends LootModifier {
    // Necesita un item, un min_count, un max_count y un boolean (looting).
    public static final Supplier<Codec<AddRandomCountItemModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item),
                            Codec.INT.fieldOf("min_count").forGetter(m -> m.minCount),
                            Codec.INT.fieldOf("max_count").forGetter(m -> m.maxCount),
                            Codec.BOOL.fieldOf("use_looting").forGetter(m -> m.useLooting)
                    )
            ).apply(inst, AddRandomCountItemModifier::new)));

    private final Item item;
    private final int minCount;
    private final int maxCount;
    private final boolean useLooting;

    public AddRandomCountItemModifier(LootItemCondition[] conditionsIn, Item item, int minCount, int maxCount, boolean useLooting) {
        super(conditionsIn);
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.useLooting = useLooting;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        int count = context.getRandom().nextInt(minCount, maxCount + 1);

        if (this.useLooting) {
            int lootingLevel = context.getLootingModifier();

            if (lootingLevel > 0) {
                count += context.getRandom().nextInt(lootingLevel + 1);
            }
        }

        if (count > 0) {
            generatedLoot.add(new ItemStack(this.item, count));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
