package com.github.requestpluginsforfree.dependency;

import org.bukkit.plugin.Plugin;

public interface Dependency<T> {
    /**
     * @return the plugin identifier
     */
    String identifier();

    /**
     * @return if the plugin is available
     */
    boolean isAvailable();

    /**
     * @param available set the field available
     */
    void available(final boolean available);

    /**
     * If DependencyRegistry founds the plugin, it'll execute this method with the plugin instance
     *
     * @param plugin plugin instance
     */
    void onAvailable(final Plugin plugin);

    /**
     * @return returns the the plugin class instance if it's found, otherwise false
     */
    T get();
}
