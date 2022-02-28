package com.aizistral.pastelgardens.handlers;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PGCEventHandler {

	/*
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onFogDensity(FogDensity event) {
		if (event.getCamera().getEntity().getLevel().dimension().equals(Level.NETHER)) {
			//if (event.getMode() == FogMode.FOG_SKY) {
			//event.setCanceled(true);
			//event.setDensity(20F);
			//}
		}
	}
	 */

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onFogRender(EntityViewRenderEvent.RenderFogEvent event) {
		if (event.getCamera().getEntity().getLevel().dimension().equals(Level.NETHER))
			if (event.getCamera().getFluidInCamera() != FogType.LAVA) {
				float distance = ClientConfigHandler.netherFogNearPlane.get().floatValue();
				float diff = ClientConfigHandler.netherFogFarPlane.get().floatValue();

				if (distance > 0) {
					RenderSystem.setShaderFogStart(distance);
				}

				if (diff > 0) {
					RenderSystem.setShaderFogEnd(distance + diff);
				}
			}
	}

}
