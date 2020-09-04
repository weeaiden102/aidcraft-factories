package ga.aidcraft.factorymod.init;

import java.util.function.Supplier;

import ga.aidcraft.factorymod.FactoryMod;
import ga.aidcraft.factorymod.FactoryMod.FactoryModTab;
import ga.aidcraft.factorymod.objects.items.coolItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = FactoryMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(FactoryMod.MOD_ID)
public class iteminit {
	public static final Item wrench = null;
	public static final Item working_wrench = null;

	public static final Item poweraxe = null;
	public static final Item powersword = null;
	public static final Item powershovelo = null;
	public static final Item powerpickaxe = null;
	public static final Item powerhoe = null;
	public static final Item scrap_helmet = null;
	public static final Item scrap_chestplate = null;
	public static final Item scrap_leggings = null;
	public static final Item scrap_boots = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new Item(new Item.Properties().group(FactoryModTab.instance)).setRegistryName("wrench"));
		event.getRegistry().register(
				new coolItem(new Item.Properties().group(FactoryModTab.instance)).setRegistryName("working_wrench"));
		event.getRegistry()
				.register(new AxeItem(powertier.POWER, 7, 5.0f, new Item.Properties().group(FactoryModTab.instance))
						.setRegistryName("poweraxe"));
		event.getRegistry()
				.register(new PickaxeItem(powertier.POWER, 7, 5.0f, new Item.Properties().group(FactoryModTab.instance))
						.setRegistryName("powerpickaxe"));
		event.getRegistry()
				.register(new SwordItem(powertier.POWER, 10, 5.0f, new Item.Properties().group(FactoryModTab.instance))
						.setRegistryName("powersword"));
		event.getRegistry()
				.register(new ShovelItem(powertier.POWER, 7, 5.0f, new Item.Properties().group(FactoryModTab.instance))
						.setRegistryName("powershovel"));
		event.getRegistry()
				.register(new HoeItem(powertier.POWER, 7, 5.0f, new Item.Properties().group(FactoryModTab.instance))
						.setRegistryName("powerhoe"));
		event.getRegistry().register(new ArmorItem(ModArmorMatirial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(FactoryModTab.instance)).setRegistryName("scrap_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMatirial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(FactoryModTab.instance)).setRegistryName("scrap_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMatirial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(FactoryModTab.instance)).setRegistryName("scrap_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMatirial.TEST, EquipmentSlotType.HEAD,
				new Item.Properties().group(FactoryModTab.instance)).setRegistryName("scrap_boots"));
	}

	public enum powertier implements IItemTier {
		POWER(4, 1500, 15.0f, 7.0f, 250, () -> {
			return Ingredient.fromItems(iteminit.wrench);
		});

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMatirial;

		private powertier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
				Supplier<Ingredient> repairMatirial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMatirial = new LazyValue<>(repairMatirial);
		}

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMatirial.getValue();
		}
	}

	public enum ModArmorMatirial implements IArmorMaterial {
		TEST(FactoryMod.MOD_ID + ":test", 5, new int[] { 1, 2, 3, 1 }, 420, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 6.9f,
				() -> {
					return Ingredient.fromItems(blockinit.scrap);
				});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 12, 12, 12, 12 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantibility;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMatirial;

		private ModArmorMatirial(String nameIn, int MaxDamageFactorIn, int[] damageReductionAmountIn,
				int enchanabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMatirialIn) {
			this.name = nameIn;
			this.maxDamageFactor = MaxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantibility = enchanabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMatirial = new LazyValue<>(repairMatirialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			// TODO Auto-generated method stub
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			// TODO Auto-generated method stub
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchantibility;
		}

		@Override
		public SoundEvent getSoundEvent() {
			// TODO Auto-generated method stub
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repairMatirial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		@Override
		public float getToughness() {
			// TODO Auto-generated method stub
			return this.toughness;
		}

		@Override
		public float func_230304_f_() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
