package org.amethystdev.testplugin;

import org.amethystdev.testplugin.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

import revxrsal.commands.bukkit.BukkitLamp;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello, world");

        // Register our command
        var lamp = BukkitLamp.builder(this).build();
        lamp.register(new TestCommand());

    }
}