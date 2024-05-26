package dev.tarna.shielddelay

import dev.tarna.shielddelay.commands.ShieldDelayCommand
import dev.tarna.shielddelay.listeners.ShieldListener
import org.bukkit.plugin.java.JavaPlugin

class ShieldDelay : JavaPlugin() {
    override fun onEnable() {
        logger.info("ShieldDelay has been enabled!")
        server.pluginManager.registerEvents(ShieldListener(this), this)
        getCommand("shielddelay")?.setExecutor(ShieldDelayCommand(this))
    }

    override fun onDisable() {
        logger.info("ShieldDelay has been disabled!")
    }
}