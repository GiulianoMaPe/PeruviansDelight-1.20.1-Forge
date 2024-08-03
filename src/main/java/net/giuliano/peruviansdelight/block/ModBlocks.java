package net.giuliano.peruviansdelight.block;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.custom.AjiAmarilloCropBlock;
import net.giuliano.peruviansdelight.block.custom.KionCropBlock;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PeruviansDelight.MOD_ID);

    public static final RegistryObject<Block> CARA = registerBlock("cara",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .requiresCorrectToolForDrops(), UniformInt.of(3,7)));

    public static final RegistryObject<Block> AJI_AMARILLO_CROP = BLOCKS.register("aji_amarillo_crop",
            () -> new AjiAmarilloCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));
    public static final RegistryObject<Block> KION_CROP = BLOCKS.register("kion_crop",
            () -> new KionCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
