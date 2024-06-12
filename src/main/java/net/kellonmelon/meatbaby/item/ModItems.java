package net.kellonmelon.meatbaby.item;

import net.kellonmelon.meatbaby.MeatBaby;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MeatBaby.MOD_ID);

    public static final RegistryObject<Item> COOKEDMEATBABY = ITEMS.register("cookedmeatbaby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB)));

    public static final RegistryObject<Item> MEATBABY = ITEMS.register("meatbaby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB)));

    public static final RegistryObject<Item> COOKEDMEATCHUNK = ITEMS.register("cookedmeatchunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB)));

    public static final RegistryObject<Item> MEATCHUNK = ITEMS.register("meatchunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
