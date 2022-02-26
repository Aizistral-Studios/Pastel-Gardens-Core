package com.aizistral.pastelgardens.mixins;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

import com.aizistral.pastelgardens.handlers.SuperpositionHandler;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.common.CuriosHelper;

@Pseudo
@Mixin(targets = "com.mrcrayfish.backpacked.integration.Curios$1")
public abstract class MixinBackpackCapability implements ICurio {
	private static final UUID SLOT_MODIFIER_ID = UUID.fromString("8a103008-0272-4603-bf15-940f5b842f55");

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
		Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
		CuriosApi.getCuriosHelper().addSlotModifier(map, "back", SLOT_MODIFIER_ID, 1, Operation.ADDITION);
		return map;
	}

	@Override
	public boolean canEquip(SlotContext slotContext) {
		return !SuperpositionHandler.hasBackpack(slotContext.entity());
	}

}
