package io.github.sojakstudio.gemgyunbabo.interfaces

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

interface CommandInterface {
    fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>?)
}