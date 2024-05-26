package dev.tarna.shielddelay

import dev.tarna.shielddelay.commands.ShieldDelayCommand
import dev.tarna.shielddelay.listeners.ShieldListener
import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

class ShieldDelay : JavaPlugin() {
    override fun onEnable() {
        logger.info("ShieldDelay has been enabled!")
        saveDefaultConfig()
        server.pluginManager.registerEvents(ShieldListener(this), this)
        getCommand("shielddelay")?.setExecutor(ShieldDelayCommand(this))
        loadBStats()
    }

    override fun onDisable() {
        logger.info("ShieldDelay has been disabled!")
    }

    private fun loadBStats() {
        Metrics(this, 22028)
        logger.info("bStats has been loaded!")
    }
}