package com.aizistral.pastelgardens.handlers;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfigHandler {
	public static ForgeConfigSpec clientConfig;

	public static ForgeConfigSpec.DoubleValue netherFogNearPlane;
	public static ForgeConfigSpec.DoubleValue netherFogFarPlane;

	public static void constructConfig() {
		final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		builder.comment("General mod config").push("Generic Config");

		netherFogNearPlane = builder
				.comment("Defines how far from the player fog starts in The Nether. Set to negative value to not override vanilla setting.")
				.defineInRange("netherFogNearPlane", 16.0, -1.0, 32768.0);

		netherFogFarPlane = builder
				.comment("Defines how far from the player fog reaches maximum opacity in The Nether. Set to negative value to not override vanilla setting.")
				.defineInRange("netherFogFarPlane", 54.0, -1.0, 32768.0);

		builder.pop();

		clientConfig = builder.build();
	}
}
