package com.github.requestpluginsforfree.dependency;

import org.bukkit.plugin.Plugin;

public abstract class Dependency<T> {
    private boolean available;
    private T instance;

    /**
     * @return the plugin identifier
     */
    public abstract String identifier();

    /**
     * @return if the plugin is available
     */
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * @param available set the field available
     */
    public void available(final boolean available) {
        this.available = available;
    }

    /**
     * If the dependency is found, it'll run this method providing the necessary parameters
     *
     * @param mainInstance the main plugin instance
     * @param plugin dependency plugin instance
     */
    public abstract void whenFound(final Plugin mainInstance, final Plugin plugin);

    /**
     * @param instance dependency instance
     *
     * @return the dependency instance
     */
    public T setInstance(final T instance){
        this.instance = instance;
        return instance;
    }

    /**
     * @return returns the the plugin class instance if it's found, otherwise false
     */
    public T getInstance() {
        return this.instance;
    }
}
