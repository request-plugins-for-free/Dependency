package com.github.requestpluginsforfree.dependency.impl;

import com.github.requestpluginsforfree.dependency.Dependency;
import me.clip.placeholderapi.PlaceholderAPIPlugin;
import org.bukkit.plugin.Plugin;

public class PlaceholderDependency extends Dependency<PlaceholderAPIPlugin> {
    /**
     * @return the plugin identifier
     */
    @Override
    public String identifier() {
        return "PlaceholderAPI";
    }

    /**
     * If DependencyRegistry founds the plugin, it'll execute this method with the plugin instance
     *
     * @param mainInstance the main plugin instance
     * @param plugin dependency plugin instance
     */
    @Override
    public void whenFound(final Plugin mainInstance, final Plugin plugin) {
        setInstance((PlaceholderAPIPlugin) plugin);
        available(true);
    }
}
