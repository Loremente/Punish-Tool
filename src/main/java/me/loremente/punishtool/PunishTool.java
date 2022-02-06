package me.loremente.punishtool;

import org.bukkit.plugin.java.JavaPlugin;

public final class PunishTool extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand());
    }
}
