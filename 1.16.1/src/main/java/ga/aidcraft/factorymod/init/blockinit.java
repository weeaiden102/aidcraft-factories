package ga.aidcraft.factorymod.init;

import ga.aidcraft.factorymod.FactoryMod;
import ga.aidcraft.factorymod.FactoryMod.FactoryModTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FactoryMod.MOD_ID)
@Mod.EventBusSubscriber(modid = FactoryMod.MOD_ID, bus = Bus.MOD)
public class blockinit {
	public static final Block scrap = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 0.6f).sound(SoundType.METAL)).setRegistryName("scrap"));
	}
	
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(scrap, new Item.Properties().group(FactoryModTab.instance)).setRegistryName("scrap"));
	}
}