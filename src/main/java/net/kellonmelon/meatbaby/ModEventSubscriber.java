
package net.kellonmelon.meatbaby;

import net.kellonmelon.meatbaby.entity.ModEntityTypes;
import net.kellonmelon.meatbaby.entity.client.MeatBabyRenderer;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MeatBaby.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MEATBABY.get(), MeatBabyEntity.createMobAttributes().build());

    }
}

