package com.github.requestpluginsforfree.dependency.api;

import com.github.requestpluginsforfree.dependency.Dependency;
import com.github.requestpluginsforfree.dependency.impl.PlaceholderDependency;
import com.github.requestpluginsforfree.dependency.impl.VaultDependency;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DependencyAPI {
    private static final List<Dependency<?>> dependencies = new ArrayList<>();
    static {
        register(new PlaceholderDependency());
        register(new VaultDependency());
    }

    public static void initialize(final Plugin instance){
        for (final Dependency<?> dependency : dependencies){
            Plugin plugin;
            if ((plugin = Bukkit.getPluginManager().getPlugin(dependency.identifier())) == null)
                continue;
            dependency.onAvailable(instance);
            instance.getLogger().info("Hooked into " + plugin.getDescription().getName() + " plugin!");
        }
    }

    /**
     * Registers the dependency to a list
     *
     * @param dependencies the dependency instance
     */
    public static void register(Dependency<?>... dependencies){
        DependencyAPI.dependencies.addAll(Arrays.asList(dependencies));
    }

    /**
     * @param identifier the dependency identifier
     *
     * @return the dependency instance, if it's available
     */
    public static Dependency<?> get(final String identifier){
        for (final Dependency<?> dependency : dependencies){
            if (dependency.identifier().equalsIgnoreCase(identifier)) return dependency;
        }
        return null;
    }
}
