package com.animania.common.items;

import java.util.List;

import com.animania.Animania;
import com.animania.config.AnimaniaConfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCookedPrimeChevon extends ItemFood
{
    private final String name = "cooked_prime_chevon";

    public ItemCookedPrimeChevon() {
        super(3, 5F, true);
        this.setAlwaysEdible();
        this.setRegistryName(new ResourceLocation(Animania.MODID, this.name));
        GameRegistry.register(this);
        this.setUnlocalizedName(Animania.MODID + "_" + this.name);
        this.setCreativeTab(Animania.TabAnimaniaResources);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.EAT;
    }

    @Override
    protected void onFoodEaten(ItemStack itemstack, World worldObj, EntityPlayer entityplayer) {
        if (!worldObj.isRemote && AnimaniaConfig.gameRules.foodsGiveBonusEffects)
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1200, 1, false, false));
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
        if (AnimaniaConfig.gameRules.foodsGiveBonusEffects)
            list.add(TextFormatting.GREEN + I18n.translateToLocal("tooltip.an.resistance"));
        list.add(TextFormatting.GOLD + I18n.translateToLocal("tooltip.an.edibleanytime"));

    }

}