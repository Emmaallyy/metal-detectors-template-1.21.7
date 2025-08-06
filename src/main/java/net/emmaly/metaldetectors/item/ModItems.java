package net.emmaly.metaldetectors.item;

import net.emmaly.metaldetectors.MetalDetectors;
import net.emmaly.metaldetectors.item.custom.*;
import net.emmaly.metaldetectors.sound.ModSounds;
import net.emmaly.metaldetectors.MetalDetectors;
import net.emmaly.metaldetectors.item.custom.AncientDebrisDetector;
import net.emmaly.metaldetectors.item.custom.DiamondDetectorItem;
import net.emmaly.metaldetectors.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item RESONATINGCORE = registerItem("resonatingcore", setting -> new Item(setting));
    public static final Item METAL_DETECTOR = registerItem("metaldetector", setting -> new MetalDetectorItem(setting.maxCount(1)));
    public static final Item DIAMOND_DETECTOR = registerItem("diamonddetector", setting -> new DiamondDetectorItem(setting.maxCount(1)));
    public static final Item ANCIENT_DEBRIS_DETECTOR = registerItem("ancientdebrisdetector", setting -> new AncientDebrisDetector(setting.maxCount(1)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MetalDetectors.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MetalDetectors.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MetalDetectors.LOGGER.info("Registering ModItems for " + MetalDetectors.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(METAL_DETECTOR);
            fabricItemGroupEntries.add(DIAMOND_DETECTOR);
            fabricItemGroupEntries.add(ANCIENT_DEBRIS_DETECTOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RESONATINGCORE);
        });
    }
}
