# Discord
You can join our discord here: https://discord.gg/yGkS3Dh

---
### Usage Example
```java

package com.github.requestpluginsforfree.example;

import com.github.requestpluginsforfree.dependency.Dependency;
import com.github.requestpluginsforfree.dependency.api.DependencyAPI;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        // registering the dependency
        DependencyAPI.register(new SecondPluginDependency());

        // initializing the api
        DependencyAPI.initialize(this);

        /*
         * The reason why we used ? below instead of SecondPlugin is
         * because it will throw ClassNotFound Exception if the plugin
         * is not found hence, ruin the whole purpose of this plugin,
         * so be careful.
         */
        Dependency<?> secondPluginDepend = DependencyAPI.get("secondplugin");
        /*
            Right now, we're checking for both things

            First, If the dependency instance is returning null (which it shouldn't be)
            Second, if #isAvailable is returning true, that means it's been found and has passed whenFound check
            but otherwise, it'll return false and simply returning
         */
        if (secondPluginDepend == null || !secondPluginDepend.isAvailable()) return;

        // getting the instance
        final SecondPlugin secondPlugin = (SecondPlugin) secondPluginDepend.getInstance();
        // executing the secret method that we've been waiting for
        secondPlugin.secretMethod(); // prints "Second Plugin Found"
    }

    // Think of this as a separate plugin
    public static class SecondPlugin extends JavaPlugin {
        // second method that no one can access :(
        public void secretMethod() {
            getLogger().info("Secret Method Found");
        }
    }

    public static class SecondPluginDependency extends Dependency<SecondPlugin> {
        /**
         * @return the plugin identifier
         */
        @Override
        public String identifier() {
            return "secondplugin";
        }

        /**
         * If the dependency is found, it'll run this method providing the necessary parameters
         *
         * @param instance the main plugin instance
         * @param plugin dependency plugin instance
         */
        @Override
        public void whenFound(final Plugin instance, final Plugin plugin) {
            // your checks here, if you have any
            
            // setting the instance for later use
            setInstance((SecondPlugin) plugin);
            // setting the availability to true to be able to use it
            available(true);
        }
    }
}
```
