package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class TimerCommand(private val timerManager: TimerManager) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("Invalid command. Use /timer resume, /timer stop, or /timer reset.")
            return true
        }

        when (args[0].toLowerCase()) {
            "resume" -> {
                if (!timerManager.isRunning()) {
                    timerManager.startTimer()
                    sender.sendMessage("Timer resumed.")
                } else {
                    sender.sendMessage("Timer is already running.")
                }
            }
            "stop" -> {
                if (timerManager.isRunning()) {
                    timerManager.stopTimer()
                    sender.sendMessage("Timer stopped at ${timerManager.getTime()} seconds.")
                } else {
                    sender.sendMessage("Timer is not running.")
                }
            }
            "reset" -> {
                timerManager.resetTimer()
                sender.sendMessage("Timer reset.")
            }
            else -> {
                sender.sendMessage("Invalid command. Use /timer resume, /timer stop, or /timer reset.")
            }
        }
        return true
    }
}
