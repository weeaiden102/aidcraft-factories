/*package ga.aidcraft.factorymod.events;

import ga.aidcraft.factorymod.FactoryMod;
import ga.aidcraft.factorymod.init.blockinit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = FactoryMod.MOD_ID, bus = Bus.FORGE)
public class testevent {
	@SubscribeEvent
	public static void Testevent(LivingJumpEvent event) {
		FactoryMod.LOGGER.info("Entity has jumped!");
		LivingEntity livingEntity = event.getEntityLiving();
		World world = livingEntity.getEntityWorld();
		world.setBlockState(livingEntity.getPosition().add(0, 5, 0), blockinit.scrap.getDefaultState());
		livingEntity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 6, 255));
		livingEntity.setGlowing(true);
	}
}
*/