package com.github.requestpluginsforfree.dependency.impl;

import com.github.requestpluginsforfree.dependency.Dependency;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultDependency extends Dependency<Economy> {
    /**
     * @return the plugin identifier
     */
    @Override
    public String identifier() {
        return "Vault";
    }

    @Override
    public void whenFound(final Plugin mainInstance, final Plugin plugin) {
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return;
        setInstance(rsp.getProvider());
        available(true);
    }
}
