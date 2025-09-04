package com.namejeb.cone_of_shame.item;

import com.namejeb.cone_of_shame.ConeOfShame;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;




import java.util.function.Function;

public class ModItems {

    // Create new item, Cone of Shame
    // public static final Item CONE_OF_SHAME = register("cone_of_shame", Item::new, new Item.Settings());

    // Create new Armor Helmet, Cone of Shame
    public static final Item CONE_OF_SHAME = register(
            "cone_of_shame",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ConeOfShameArmorMaterial.BASE_DURABILITY)).armor(ConeOfShameArmorMaterial.INSTANCE, EquipmentType.HELMET)
    );

    // Create new Armor Helmet, Test Helmet, for testing purposes
    public static final Item TEST_HELMET = register(
            "test_helmet",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ConeOfShameArmorMaterial.BASE_DURABILITY)).armor(ArmorMaterials.TURTLE_SCUTE, EquipmentType.HELMET)
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ConeOfShame.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.CONE_OF_SHAME));
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.TEST_HELMET));
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.CONE_OF_SHAME_HELMET));
    }
}
