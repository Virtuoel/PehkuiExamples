package com.example.examplemod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import virtuoel.pehkui.api.ScaleTypes;

public class ExampleItem extends Item {
	public ExampleItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (!world.isClientSide) {
			ScaleTypes.BASE.getScaleData(player).setTargetScale(player.isShiftKeyDown() ? 1.0F : 2.0F);
		}

		return ActionResult.success(player.getItemInHand(hand));
	}
}
