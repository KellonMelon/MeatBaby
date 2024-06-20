package net.kellonmelon.meatbaby.item;

import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.entity.ModEntityTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MeatBaby.MOD_ID);

    public static final RegistryObject<Item> COOKEDMEATBABY = ITEMS.register("cookedmeatbaby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB).food(Foods.COOKEDMEATBABY)));


    public static final RegistryObject<Item> MEATBABY = ITEMS.register("meatbaby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB).food(Foods.MEATBABY)));

    public static final RegistryObject<Item> COOKEDMEATCHUNK = ITEMS.register("cookedmeatchunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB).food(Foods.COOKEDMEATCHUNK)));

    public static final RegistryObject<Item> MEATCHUNK = ITEMS.register("meatchunk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB).food(Foods.MEATCHUNK)));

    public static final RegistryObject<Item> MEATBABYSPAWNEGG = ITEMS.register("meatbabyspawnegg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MEATBABY,0xdb4a30,0xa83622,
                    new Item.Properties().tab(ModCreativeModeTab.MEATBABY_TAB)));

    public static class Foods {
        public static final FoodProperties COOKEDMEATBABY = new FoodProperties.Builder().nutrition(10).saturationMod(10).meat().build();
        public static final FoodProperties MEATBABY = new FoodProperties.Builder().nutrition(4).saturationMod(4).meat().build();
        public static final FoodProperties COOKEDMEATCHUNK = new FoodProperties.Builder().nutrition(5).saturationMod(5).meat().build();
        public static final FoodProperties MEATCHUNK = new FoodProperties.Builder().nutrition(2).saturationMod(2).meat().build();
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
