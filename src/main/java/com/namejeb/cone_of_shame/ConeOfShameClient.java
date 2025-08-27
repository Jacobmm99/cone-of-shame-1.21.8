package com.namejeb.cone_of_shame;

import com.namejeb.cone_of_shame.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ConeOfShameClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (stack.isOf(ModItems.CONE_OF_SHAME)) {
                lines.add(Text.translatable("item.cone_of_shame.cone_of_shame.tooltip").formatted(Formatting.GOLD));
            }
        });
    }
}
