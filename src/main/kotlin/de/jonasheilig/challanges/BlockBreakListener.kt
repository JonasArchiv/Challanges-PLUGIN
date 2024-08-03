package de.jonasheilig.challanges

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockBreakListener(private val plugin: Challanges) : Listener {

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val block = event.block
        if (block.type == plugin.currentBlock) {
            plugin.setNextBlock()
            event.player.sendMessage("You found and broke the block! Next block set.")
        }
    }
}
