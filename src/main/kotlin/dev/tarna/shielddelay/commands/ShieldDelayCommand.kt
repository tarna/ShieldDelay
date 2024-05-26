package dev.tarna.shielddelay.commands

import dev.tarna.shielddelay.ShieldDelay
import dev.tarna.shielddelay.utils.send
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

class ShieldDelayCommand(private val plugin: ShieldDelay) : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isNotEmpty()) {
            val arg = args[0].lowercase()
            if (arg == "reload") {
                plugin.reloadConfig()
                sender.send("<green>Config reloaded.")
                return true
            } else if (arg == "set") {
                if (args.size > 1) {
                    val delay = args[1].toIntOrNull()
                    if (delay == null) {
                        sender.send("<red>Invalid delay.")
                        return true
                    }
                    plugin.config.set("shield-delay", delay)
                    plugin.saveConfig()
                    sender.send("<green>Shield delay set to <red>$delay <green>ticks.")
                    return true
                } else {
                    sender.send("<red>Usage: /$label set <delay>")
                    return true
                }
            } else if (arg == "get") {
                val delay = plugin.config.getInt("shield-delay")
                sender.send("<green>The shield delay is <red>$delay <green>ticks.")
                return true
            } else {
                sender.send("<red>Usage: /$label <reload|set|get>")
                return true
            }
        }

        sender.send("<blue>ShieldDelay <yellow>v${plugin.description.version}")
        sender.send("<blue>Authors: <yellow>${plugin.description.authors.joinToString(", ")}")
        sender.send("<blue>Usage: <yellow>/$label <reload|set|get> [delay]")
        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        if (args.size == 1) {
            return mutableListOf("reload", "set", "get")
        }
        return null
    }
}