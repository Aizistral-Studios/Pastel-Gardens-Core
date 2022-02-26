package com.aizistral.pastelgardens.handlers;

import java.util.Optional;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.CuriosApi;

public class SuperpositionHandler {
	private static Item backpack = null;

	/**
	 * Checks whether LivingEntity has given Item equipped in it's Curios slots.
	 * @return True if has, false otherwise.
	 */

	public static boolean hasCurio(LivingEntity entity, Item curio) {
		final Optional<ImmutableTriple<String, Integer, ItemStack>> data = CuriosApi.getCuriosHelper().findEquippedCurio(curio, entity);
		return data.isPresent();
	}

	public static boolean hasBackpack(LivingEntity entity) {
		if (backpack == null) {
			backpack = ForgeRegistries.ITEMS.getValue(new ResourceLocation("backpacked", "backpack"));
		}

		return hasCurio(entity, backpack);
	}

}
