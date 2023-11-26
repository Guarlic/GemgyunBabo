package io.github.sojakstudio.gemgyunbabo.commands

import io.github.sojakstudio.gemgyunbabo.interfaces.CommandInterface
import io.github.sojakstudio.gemgyunbabo.interfaces.Name
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Name("trash")
class Trash : CommandInterface {
    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>?) {
        val player = sender as Player

        val inventory = Bukkit.createInventory(null, 9, "쓰레기통")

        player.openInventory(inventory)
    }
}