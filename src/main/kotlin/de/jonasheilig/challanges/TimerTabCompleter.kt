package de.jonasheilig.challanges

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class TimerTabCompleter : TabCompleter {

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            val subcommands = listOf("resume", "stop", "reset")
            return subcommands.filter { it.startsWith(args[0], ignoreCase = true) }
        }
        return emptyList()
    }
}
