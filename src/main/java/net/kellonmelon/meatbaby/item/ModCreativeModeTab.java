package net.kellonmelon.meatbaby.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MEATBABY_TAB = new CreativeModeTab("MeatBaby") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MEATBABY.get());
        }
    };
}
