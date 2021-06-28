package rmc.mixins.evilcraft_newmagic.inject;

import org.cyclops.cyclopscore.config.ConfigHandler;
import org.cyclops.cyclopscore.config.extendedconfig.ExtendedConfig;
import org.cyclops.evilcraft.world.biome.BiomeDegradedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = ConfigHandler.class)
public abstract class ConfigHandlerMixin {

    @Inject(method = "Lorg/cyclops/cyclopscore/config/ConfigHandler;addConfigurable(Lorg/cyclops/cyclopscore/config/extendedconfig/ExtendedConfig;)Z",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private void disableDegradedRegistration(ExtendedConfig<?, ?> e, CallbackInfoReturnable<Boolean> mixin) {
        if (e instanceof BiomeDegradedConfig) {
            mixin.setReturnValue(false);
        }
    }

}