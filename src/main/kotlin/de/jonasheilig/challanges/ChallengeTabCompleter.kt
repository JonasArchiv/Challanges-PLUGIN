package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class ChallengeTabCompleter : TabCompleter {

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String>? {
        if (args.size == 1) {
            return listOf("challange1", "challange2")
        }
        return emptyList()
    }
}
