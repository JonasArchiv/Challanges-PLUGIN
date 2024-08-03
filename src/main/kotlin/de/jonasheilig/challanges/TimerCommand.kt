package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class TimerCommand(private val plugin: JavaPlugin) : CommandExecutor {

    private var task: BukkitRunnable? = null
    private var time: Int = 0
    private var isRunning: Boolean = false

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        when (args[0].toLowerCase()) {
            "resume" -> {
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
                    sender.sendMessage("Timer resumed.")
                } else {
                    sender.sendMessage("Timer is already running.")
                }
            }
            "stop" -> {
                if (isRunning) {
                    task?.cancel()
                    isRunning = false
                    sender.sendMessage("Timer stopped at $time seconds.")
                } else {
                    sender.sendMessage("Timer is not running.")
                }
            }
            "reset" -> {
                task?.cancel()
                time = 0
                isRunning = false
                plugin.server.onlinePlayers.forEach { player ->
                    player.sendActionBar("Timer: 0 seconds")
                }
                sender.sendMessage("Timer reset.")
            }
            else -> {
                sender.sendMessage("Invalid command. Use /timer resume, /timer stop, or /timer reset.")
            }
        }
        return true
    }
}
