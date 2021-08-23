package com.github.requestpluginsforfree.dependency.impl;

import com.github.requestpluginsforfree.dependency.Dependency;
import me.clip.placeholderapi.PlaceholderAPIPlugin;
import org.bukkit.plugin.Plugin;

public class PlaceholderDependency implements Dependency<PlaceholderAPIPlugin> {
    private final String identifier;

    private boolean available;
    private PlaceholderAPIPlugin placeholderApi;

    public PlaceholderDependency() {
        this.identifier = "PlaceholderAPI";
    }

    /**
     * @return the plugin identifier
     */
    @Override
    public String identifier() {
        return this.identifier;
    }

    /**
     * @return if the plugin is available
     */
    @Override
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * @param available set the field available
     */
    @Override
    public void available(final boolean available) {
        this.available = available;
    }

    /**
     * If DependencyRegistry founds the plugin, it'll execute this method with the plugin instance
     *
     * @param plugin plugin instance
     */
    @Override
    public void onAvailable(final Plugin plugin) {
        if (plugin instanceof PlaceholderAPIPlugin) {
            this.placeholderApi = (PlaceholderAPIPlugin) plugin;
        }
    }

    /**
     * @return returns the the plugin class instance if it's found, otherwise false
     */
    @Override
    public PlaceholderAPIPlugin get() {
        return isAvailable() ? placeholderApi : null;
    }
}
