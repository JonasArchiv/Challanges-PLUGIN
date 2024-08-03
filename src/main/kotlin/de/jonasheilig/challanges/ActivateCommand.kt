package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ActivateCommand(private val plugin: Challanges) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (args.isNotEmpty()) {
                when (args[0]) {
                    "challange1" -> {
                        plugin.setNextBlock()
                        sender.sendMessage("Challenge 1 activated!")
                        return true
                    }
                    else -> {
                        sender.sendMessage("Unknown challenge: ${args[0]}")
                        return false
                    }
                }
            } else {
                sender.sendMessage("Please specify a challenge.")
                return false
            }
        }
        return false
    }
}
