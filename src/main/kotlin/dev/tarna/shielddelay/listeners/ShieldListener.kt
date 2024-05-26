package dev.tarna.shielddelay.listeners

import dev.tarna.shielddelay.ShieldDelay
import io.papermc.paper.event.player.PlayerShieldDisableEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class ShieldListener(private val plugin: ShieldDelay) : Listener {
    @EventHandler
    fun onShieldDisable(event: PlayerShieldDisableEvent) {
        val delay = plugin.config.getInt("shield-delay")
        event.cooldown = delay
    }
}