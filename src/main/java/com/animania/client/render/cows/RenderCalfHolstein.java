package com.animania.client.render.cows;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.animania.client.models.ModelCalf;
import com.animania.common.entities.cows.EntityCalfHolstein;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCalfHolstein<T extends EntityCalfHolstein> extends RenderLiving<T>
{
    public static final Factory           FACTORY          = new Factory();

    private static final ResourceLocation cowTextures      = new ResourceLocation("animania:textures/entity/cows/calf_holstein.png");
    private static final ResourceLocation cowTexturesBlink = new ResourceLocation("animania:textures/entity/cows/calf_holstein_blink.png");
    private static final ResourceLocation purpTextures     	= new ResourceLocation("animania:textures/entity/cows/calf_purplicious.png");
	private static final ResourceLocation purpTexturesBlink = new ResourceLocation("animania:textures/entity/cows/calf_purplicious.png");
    Random                                rand             = new Random();

    public RenderCalfHolstein(RenderManager rm) {
        super(rm, new ModelCalf(), 0.5F);
    }

    protected ResourceLocation getCowTextures(T par1EntityCow) {

		if (par1EntityCow.getCustomNameTag().equals("Purp")) {
			return RenderCalfHolstein.purpTextures; 
		} else {
			return RenderCalfHolstein.cowTextures;
		}
	}

	protected ResourceLocation getCowTexturesBlink(T par1EntityCow) {
		if (par1EntityCow.getCustomNameTag().equals("Purp")) {
			return RenderCalfHolstein.purpTexturesBlink; 
		} else {
			return RenderCalfHolstein.cowTexturesBlink;
		}
	}

    @Override
    protected void preRenderCallback(T entityliving, float f) {
        this.preRenderScale(entityliving, f);
    }

    protected void preRenderScale(T entity, float f) {

        float age = entity.getEntityAge();

        GL11.glScalef(1.0F + age, 1.0F + age, 1.0F + age);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        int blinkTimer = entity.blinkTimer;

        if (blinkTimer < 7 && blinkTimer >= 0)
            return this.getCowTexturesBlink(entity);
        else
            return this.getCowTextures(entity);
    }

    static class Factory<T extends EntityCalfHolstein> implements IRenderFactory<T>
    {
        @Override
        public Render<? super T> createRenderFor(RenderManager manager) {
            return new RenderCalfHolstein(manager);
        }
    }
}