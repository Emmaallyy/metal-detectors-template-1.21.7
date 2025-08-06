package net.emmaly.metaldetectors.sound;

import net.emmaly.metaldetectors.MetalDetectors;
import net.emmaly.metaldetectors.MetalDetectors;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent BEEP = registerSoundEvent("beep");
    public static final SoundEvent DIAMONDBEEP = registerSoundEvent("diamondbeep");
    public static final SoundEvent ANCIENTDEBRISBEEP = registerSoundEvent("ancientdebrisbeep");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MetalDetectors.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        MetalDetectors.LOGGER.info("Registering Mod Sounds for " + MetalDetectors.MOD_ID);
    }

}
