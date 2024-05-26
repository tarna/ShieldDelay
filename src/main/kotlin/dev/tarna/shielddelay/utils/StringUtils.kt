package dev.tarna.shielddelay.utils

import net.kyori.adventure.text.minimessage.MiniMessage

val mm = MiniMessage.miniMessage()

fun String.color() = mm.deserialize(this)