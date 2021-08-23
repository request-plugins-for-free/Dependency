package com.github.requestpluginsforfree.dependency.impl;

import com.github.requestpluginsforfree.dependency.Dependency;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultDependency implements Dependency<Economy> {
    private boolean available;
    private Economy economy;

    /**
     * @return the plugin identifier
     */
    @Override
    public String identifier() {
        return "Vault";
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
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        this.economy = rsp.getProvider();
    }

    /**
     * @return returns the the plugin class instance if it's found, otherwise false
     */
    @Override
    public Economy get() {
        return this.economy;
    }
}
