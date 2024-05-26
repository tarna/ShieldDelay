package dev.tarna.shielddelay.utils

import org.bukkit.command.CommandSender

fun CommandSender.send(message: String) = sendMessage(message.color())