package de.jonasheilig.challanges

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class TimerManager(private val plugin: JavaPlugin) {

    private var task: BukkitRunnable? = null
    private var time: Int = 0
    private var isRunning: Boolean = false

    fun startTimer() {
        if (!isRunning) {
            task = object : BukkitRunnable() {
                override fun run() {
                    time++
                    plugin.server.onlinePlayers.forEach { player ->
                        player.sendActionBar("Timer: $time seconds")
                    }
                }
            }
            task?.runTaskTimer(plugin, 0L, 20L) // Schedule task to run every second (20 ticks)
            isRunning = true
        }
    }

    fun stopTimer() {
        task?.cancel()
        isRunning = false
    }

    fun resetTimer() {
        task?.cancel()
        time = 0
        isRunning = false
        plugin.server.onlinePlayers.forEach { player ->
            player.sendActionBar("Timer: 0 seconds")
        }
    }

    fun getTime(): Int {
        return time
    }

    fun isRunning(): Boolean {
        return isRunning
    }
}
