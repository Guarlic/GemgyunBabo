package io.github.sojakstudio.gemgyunbabo

import io.github.sojakstudio.gemgyunbabo.interfaces.Name
import io.github.sojakstudio.gemgyunbabo.lists.commandList
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class OnCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val name = command.name

        for (_command in commandList) {
            val commandName = _command.javaClass.getAnnotation(Name::class.java).value
            if (commandName != name) continue

            _command.execute(sender, command, label, args)

            break
        }

        return true
    }
}