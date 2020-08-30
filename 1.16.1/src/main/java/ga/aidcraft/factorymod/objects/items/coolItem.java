package ga.aidcraft.factorymod.objects.items;

import java.util.List;

import ga.aidcraft.factorymod.init.blockinit;
import ga.aidcraft.factorymod.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class coolItem extends Item{

	public coolItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("right click to get absorpsion"));
		} else {
			tooltip.add(new StringTextComponent("Hold "+"\u00A75"+"SHIFT"+"\u00A77"+" for more information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
		
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		// TODO Auto-generated method stub
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 500, 255));
		worldIn.setRainStrength(1.0f);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		// TODO Auto-generated method stub
		entity.getEntityWorld().setBlockState(new BlockPos(entity.getPositionVec().add(0, -1, 0)), blockinit.scrap.getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}
}
