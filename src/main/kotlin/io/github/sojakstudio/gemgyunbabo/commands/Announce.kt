package io.github.sojakstudio.gemgyunbabo.commands

import io.github.sojakstudio.gemgyunbabo.interfaces.CommandInterface
import io.github.sojakstudio.gemgyunbabo.interfaces.Name
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Name("announce")
class Announce : CommandInterface {
    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>?) {
        val player = sender as Player
        val players = player.server.onlinePlayers
        val name = player.name

        var text = ""

        if (args!!.isEmpty()) return

        for (msg in args) {
            text += "$msg "
        }

        for (_player in players) {
            _player.sendMessage("${ChatColor.GOLD}[ 공지 ] ${ChatColor.GREEN}${name}: ${ChatColor.WHITE}$text")
            _player.sendTitle(
                "${ChatColor.GOLD}[ 공지 ]",
                "${ChatColor.GREEN}${name}: ${ChatColor.WHITE}$text",
                0,
                100,
                0
            )
        }
    }
}