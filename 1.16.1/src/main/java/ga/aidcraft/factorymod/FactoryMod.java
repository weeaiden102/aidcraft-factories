package ga.aidcraft.factorymod;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ga.aidcraft.factorymod.init.blockinit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("factorymod")
public class FactoryMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "factorymod";
    public static FactoryMod instance;
    
    public FactoryMod() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        modEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);

        instance = this;
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    	
    }
    
    public static class FactoryModTab extends ItemGroup{
    	public static final FactoryModTab instance = new FactoryModTab(ItemGroup.GROUPS.length, "Factory Mod");
    	private FactoryModTab(int index, String label) {
    		super(index, label);
    	}
    	@Override
    	public ItemStack createIcon() {
    		
    		return new ItemStack(blockinit.scrap);
    	}
    }

}
