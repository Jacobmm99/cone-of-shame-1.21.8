package com.namejeb.cone_of_shame;

import com.namejeb.cone_of_shame.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeOfShame implements ModInitializer {
	public static final String MOD_ID = "cone_of_shame";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.initialize();
	}
}