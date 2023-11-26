package io.github.sojakstudio.gemgyunbabo

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class EventListener : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        val name = player.name
        val scoreboard = Bukkit.getScoreboardManager().mainScoreboard

        var teamName = ""

        for (team in scoreboard.teams) {
            if (team.hasEntity(player)) {
                teamName = team.prefix
            }
        }

        event.joinMessage(
            Component.text("⏺ $teamName$name")
                .color(NamedTextColor.GREEN)
                .decorate(TextDecoration.BOLD)
        )
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        val player = event.player
        val name = player.name
        val scoreboard = Bukkit.getScoreboardManager().mainScoreboard

        var teamName = ""

        for (team in scoreboard.teams) {
            if (team.hasEntity(player)) {
                teamName = team.prefix
            }
        }

        event.quitMessage(
            Component.text("⏺ $teamName$name")
                .color(NamedTextColor.RED)
                .decorate(TextDecoration.BOLD)
        )
    }

    @EventHandler
    fun onChat(event: PlayerChatEvent) {
        val player = event.player
        val name = player.name
        val message = event.message
        val scoreboard = Bukkit.getScoreboardManager().mainScoreboard

        var teamName = ""
        var teamColor = ChatColor.WHITE

        for (team in scoreboard.teams) {
            if (team.hasEntity(player)) {
                teamName = team.prefix
                teamColor = team.color
            }
        }

        event.format = "$teamColor$teamName${ChatColor.GRAY}$name: ${ChatColor.WHITE}$message"
    }

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        val player = event.player
        val name = player.name
        val scoreboard = Bukkit.getScoreboardManager().mainScoreboard

        var teamName = ""
        var teamColor = NamedTextColor.RED

        for (team in scoreboard.teams) {
            if (team.hasEntity(player)) {
                teamName = team.prefix
                teamColor = team.color() as NamedTextColor
            }
        }

        event.deathMessage(
            Component.text("")
                .append(
                    Component.text()
                        .content(teamName)
                        .color(teamColor)
                )
                .append(
                    Component.text()
                        .content("$name 이(가) 죽었다.")
                        .color(NamedTextColor.RED)
                )
        )
    }
}