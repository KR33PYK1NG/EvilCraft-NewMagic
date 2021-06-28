package rmc.mixins.evilcraft_newmagic.inject;

import org.cyclops.evilcraft.block.BlockInfestedNetherConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.biome.Biome.Category;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = BlockInfestedNetherConfig.class)
public abstract class BlockInfestedNetherConfigMixin {

    @Inject(method = "Lorg/cyclops/evilcraft/block/BlockInfestedNetherConfig;onBiomeLoadingEvent(Lnet/minecraftforge/event/world/BiomeLoadingEvent;)V",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private void excludeAdventBiomes(BiomeLoadingEvent event, CallbackInfo mixin) {
        if (event.getCategory() == Category.NONE) {
            mixin.cancel();
        }
    }

}