package io.github.sojakstudio.gemgyunbabo

import io.github.sojakstudio.gemgyunbabo.interfaces.Name
import io.github.sojakstudio.gemgyunbabo.lists.commandList
import org.bukkit.plugin.java.JavaPlugin

class GemgyunBabo : JavaPlugin() {
    override fun onEnable() {
        logger.info("Gemgyun is babo!!")

        server.pluginManager.registerEvents(EventListener(), this)

        for (command in commandList) {
            val commandName = command.javaClass.getAnnotation(Name::class.java).value
            getCommand(commandName)!!.setExecutor(OnCommand())
        }
    }

    override fun onDisable() {
        logger.info("Gemgyun is babo..")
    }
}