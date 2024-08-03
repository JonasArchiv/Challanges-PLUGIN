package de.jonasheilig.challanges

import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Challanges : JavaPlugin() {

    var currentBlock: Material? = null
    private val challenge1 = Challange1(this)

    override fun onEnable() {

        this.getCommand("activate")?.setExecutor(ActivateCommand(this))
        this.getCommand("activate")?.tabCompleter = ChallengeTabCompleter()
        this.getCommand("deactivate")?.setExecutor(DeactivateCommand(this))
        this.getCommand("deactivate")?.tabCompleter = ChallengeTabCompleter()
        server.pluginManager.registerEvents(BlockBreakListener(this), this
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun setNextBlock() {
        currentBlock = challenge1.getRandomBlock()
        BossBarManager.updateBossBar(currentBlock)
    }

    fun clearCurrentBlock() {
        currentBlock = null
        BossBarManager.clearBossBar()
    }
}
