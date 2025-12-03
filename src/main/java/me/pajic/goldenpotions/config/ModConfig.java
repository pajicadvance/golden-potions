package me.pajic.goldenpotions.config;

import me.fzzyhmstrs.fzzy_config.annotations.Version;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.pajic.goldenpotions.GoldenPotions;

@Version(version = 1)
public class ModConfig extends Config {
    public ModConfig() {
        super(GoldenPotions.CONFIG_RL);
    }

	public ValidatedBoolean edibleGoldenApple = new ValidatedBoolean(false);
	public ValidatedBoolean edibleEnchantedGoldenApple = new ValidatedBoolean(false);
	public ValidatedBoolean edibleGoldenCarrot = new ValidatedBoolean(false);
}
