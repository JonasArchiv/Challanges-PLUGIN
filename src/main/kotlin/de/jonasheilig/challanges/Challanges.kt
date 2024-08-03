package de.jonasheilig.challanges

import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class Challanges : JavaPlugin() {

    var currentBlock: Material? = null
    var isChallenge1Active: Boolean = false
    var isChallenge2Active: Boolean = false
    private val challenge1 = Challange1(this)
    private val challenge2 = Challange2(this)
    private lateinit var timerManager: TimerManager

    override fun onEnable() {
        // Plugin startup logic
        this.getCommand("activate")?.setExecutor(ActivateCommand(this))
        this.getCommand("activate")?.tabCompleter = ChallengeTabCompleter()
        this.getCommand("deactivate")?.setExecutor(DeactivateCommand(this))
        this.getCommand("deactivate")?.tabCompleter = ChallengeTabCompleter()
        timerManager = TimerManager(this)
        this.getCommand("timer")?.setExecutor(TimerCommand(timerManager))
        this.getCommand("timer")?.tabCompleter = TimerTabCompleter()
        server.pluginManager.registerEvents(BlockBreakListener(this), this)
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

    fun giveRandomItem() {
        val randomItem = challenge2.getRandomItem()
        server.onlinePlayers.forEach { player ->
            player.inventory.addItem(randomItem)
            val message = TextComponent("Item to search: ${randomItem.type}")
            player.sendMessage(message.toLegacyText())
        }
    }

    fun deactivateChallenge1() {
        clearCurrentBlock()
        isChallenge1Active = false
    }

    fun deactivateChallenge2() {
        isChallenge2Active = false
    }
}
