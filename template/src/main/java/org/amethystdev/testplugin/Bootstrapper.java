package org.amethystdev.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;

public class Bootstrapper implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {

    }

    @Override
    public JavaPlugin createPlugin(PluginProviderContext context) {
        return new Main();
    }
}
