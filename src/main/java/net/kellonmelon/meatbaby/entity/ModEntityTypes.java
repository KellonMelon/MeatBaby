package net.kellonmelon.meatbaby.entity;

import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MeatBaby.MOD_ID);

    public static final RegistryObject<EntityType<MeatBabyEntity>> MEATBABY =
            ENTITY_TYPES.register("meatbabyentity",
                    () -> EntityType.Builder.of(MeatBabyEntity::new, MobCategory.MONSTER)
                            .sized(0.8f,0.8f)
                            .build(new ResourceLocation(MeatBaby.MOD_ID,"meatbabyentity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
