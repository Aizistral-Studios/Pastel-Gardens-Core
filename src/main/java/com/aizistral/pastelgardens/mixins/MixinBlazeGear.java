package com.aizistral.pastelgardens.mixins;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

@Pseudo
@Mixin(targets = {
		"com.flashfyre.blazegear.items.BrimsteelArmourItem",
		"com.flashfyre.blazegear.items.BrimsteelAxeItem",
		"com.flashfyre.blazegear.items.BrimsteelHoeItem",
		"com.flashfyre.blazegear.items.BrimsteelHorseArmourItem",
		"com.flashfyre.blazegear.items.BrimsteelPickaxeItem",
		"com.flashfyre.blazegear.items.BrimsteelShovelItem",
		"com.flashfyre.blazegear.items.BrimsteelSwordItem",
})
public class MixinBlazeGear extends Item {

	public MixinBlazeGear() {
		super(null);
		throw new IllegalStateException("Can't touch this");
	}

	/**
	 * @reason I shall not bear the sight of those imperfect poorly wrapped tooltips.
	 * @author Aizistral
	 */

	/*
	@Override
	//@Overwrite(aliases = "m_7373_", remap = false)
	public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flag) {
		Item item = this;

		if (item instanceof ArmorItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_armor1"));
		} else if (item instanceof AxeItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_axe1"));
		} else if (item instanceof HoeItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_hoe1"));
		} else if (item instanceof HorseArmorItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_horse_armor1"));
		} else if (item instanceof PickaxeItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_pickaxe1"));
		} else if (item instanceof ShovelItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_shovel1"));
		} else if (item instanceof SwordItem) {
			list.add(new TranslatableComponent("pastelgardens.tooltip.brimsteel_sword1"));
		}
	}
	 */

}
