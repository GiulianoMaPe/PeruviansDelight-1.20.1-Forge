package net.giuliano.peruviansdelight.block;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.custom.*;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.worldgen.tree.LimoneroTreeGrower;
import net.giuliano.peruviansdelight.worldgen.tree.PaltoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> AJI_AMARILLO_CROP = BLOCKS.register("ajies_amarillos",
            () -> new AjiAmarilloCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> KION_CROP = BLOCKS.register("kiones",
            () -> new KionCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));
    public static final RegistryObject<Block> SOYA_CROP = BLOCKS.register("soyas",
            () -> new SoyaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CAMOTE_CROP = BLOCKS.register("camotes",
            () -> new CamoteCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));
    public static final RegistryObject<Block> YUCA_CROP = BLOCKS.register("yucas",
            () -> new YucaCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PALTO_LEAVES = registerBlock("palto_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> LIMONERO_LEAVES = registerBlock("limonero_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> SEMILLA_PALTA = registerBlock("semilla_palta",
            () -> new SaplingBlock(new PaltoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SEMILLAS_LIMON = registerBlock("semillas_limon",
            () -> new SaplingBlock(new LimoneroTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

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
