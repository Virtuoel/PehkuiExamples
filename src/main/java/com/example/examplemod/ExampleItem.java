package com.example.examplemod;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import virtuoel.pehkui.api.ScaleTypes;

public class ExampleItem extends Item {
	public ExampleItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (!world.isClientSide) {
			ScaleTypes.BASE.getScaleData(player).setTargetScale(player.isShiftKeyDown() ? 1.0F : 2.0F);
		}

		return InteractionResultHolder.success(player.getItemInHand(hand));
	}
}
