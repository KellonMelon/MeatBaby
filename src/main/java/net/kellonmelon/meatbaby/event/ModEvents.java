package net.kellonmelon.meatbaby.event;

import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.entity.ModEntityTypes;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MeatBaby.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MEATBABY.get(), MeatBabyEntity.setAttributes().build());
    }
}