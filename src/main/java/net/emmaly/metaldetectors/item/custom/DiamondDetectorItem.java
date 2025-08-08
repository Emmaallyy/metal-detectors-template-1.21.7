package net.emmaly.metaldetectors.item.custom;

import net.emmaly.metaldetectors.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondDetectorItem extends Item {
    public DiamondDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!entity.getWorld().isClient()) {
            BlockPos playerPosition = entity.getBlockPos();

            if (selected) {



                for (int y = -10; y <= 10; y++) {
                    for (int x = -5; x <= 5; x++) {
                        for (int z = -10; z <= 10; z++) {
                            BlockState state = entity.getWorld().getBlockState(playerPosition.add(y, x, z));



                            if (isOre(state) && world.getTime() % 20 == 0) {

                                outputParticles(playerPosition.add(y, x, z), (ServerWorld) world);


                            }
                        }
                    }


                }
            }


        }



    }

    private boolean isOre(BlockState state) {
        return state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
    private void outputParticles(BlockPos blockPos, ServerWorld world) {
        double d = blockPos.getX() + 0.5;
        double e = blockPos.getY() + 0.5;
        double f = blockPos.getZ() + 0.5;
        world.spawnParticles(ParticleTypes.GLOW, d, e, f, 20, 0.1, 0.1, 0.1, 0.1);
        world.playSound(null, blockPos, ModSounds.DIAMONDBEEP, SoundCategory.PLAYERS, 1f, 1f);



    }
}