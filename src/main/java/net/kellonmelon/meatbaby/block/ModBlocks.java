package net.kellonmelon.meatbaby.block;

import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.item.ModCreativeModeTab;
import net.kellonmelon.meatbaby.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MeatBaby.MOD_ID);

    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meatblock",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f)
                    .sound(SoundType.SLIME_BLOCK)),
                    //.requiresCorrectToolForDrops()),
            ModCreativeModeTab.MEATBABY_TAB);

    public static final RegistryObject<Block> COOKED_MEAT_BLOCK = registerBlock("cookedmeatblock",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f)
                    .sound(SoundType.CORAL_BLOCK)),
            //.requiresCorrectToolForDrops()),
            ModCreativeModeTab.MEATBABY_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
