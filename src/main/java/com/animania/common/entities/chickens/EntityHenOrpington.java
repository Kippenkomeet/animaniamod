package com.animania.common.entities.chickens;

import com.animania.common.handler.ItemHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHenOrpington extends EntityHenBase
{

	public EntityHenOrpington(World worldIn)
	{
		super(worldIn);
		this.type = ChickenType.ORPINGTON;
		this.resourceLocation = new ResourceLocation("animania:textures/entity/chickens/hen_golden.png");
		this.resourceLocationBlink = new ResourceLocation("animania:textures/entity/chickens/hen_golden_blink.png");
		this.oldDropRaw = ItemHandler.rawOrpingtonChicken;
		this.oldDropCooked = ItemHandler.cookedOrpingtonChicken;
		this.dropRaw = ItemHandler.rawPrimeChicken;
		this.dropCooked = ItemHandler.cookedPrimeChicken;
	}
	
	@Override
	public int getPrimaryEggColor()
	{
		return 15980429;
	}
	
	@Override
	public int getSecondaryEggColor()
	{
		return 13270563;
	}
}