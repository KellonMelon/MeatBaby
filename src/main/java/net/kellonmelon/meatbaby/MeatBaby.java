package net.kellonmelon.meatbaby;

import com.mojang.logging.LogUtils;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.kellonmelon.meatbaby.block.ModBlocks;
import net.kellonmelon.meatbaby.entity.ModEntityTypes;
import net.kellonmelon.meatbaby.entity.client.MeatBabyRenderer;
import net.kellonmelon.meatbaby.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(MeatBaby.MOD_ID)
public class MeatBaby
{
    public static final String MOD_ID = "meatbaby";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public MeatBaby()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        GeckoLib.initialize();
        ModEntityTypes.register(modEventBus);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("MeatBaby setup");
    }


    @SubscribeEvent
    public void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        Level world = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        BlockState placedBlock = event.getPlacedBlock();

        // Check if a carved pumpkin is placed
        if (placedBlock.getBlock() == Blocks.CARVED_PUMPKIN) {
            // Check if the block below is the meat block
            BlockState blockBelow = world.getBlockState(pos.below());
            if (blockBelow.getBlock() == ModBlocks.MEAT_BLOCK.get()) {
                System.out.println("Carved Pumpkin placed on top of Meat Block at " + pos);

                if (!world.isClientSide) {
                    // Spawn the MeatBabyEntity
                    ServerLevel serverWorld = (ServerLevel) world;
                    MeatBabyEntity meatBaby = new MeatBabyEntity(ModEntityTypes.MEATBABY.get(), serverWorld);
                    meatBaby.moveTo(pos.getX() + 0.5, pos.getY() - 1, pos.getZ() + 0.5, 0.0F, 0.0F);
                    serverWorld.addFreshEntity(meatBaby);

                    // Remove the meat block and carved pumpkin
                    world.destroyBlock(pos, false);
                    world.destroyBlock(pos.below(), false);
                }
            }
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.MEATBABY.get(), MeatBabyRenderer::new);
        }
    }



}
