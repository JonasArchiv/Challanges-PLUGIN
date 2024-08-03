package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DeactivateCommand(private val plugin: Challanges) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            plugin.clearCurrentBlock()
            sender.sendMessage("Challenge deactivated!")
            return true
        }
        return false
    }
}
