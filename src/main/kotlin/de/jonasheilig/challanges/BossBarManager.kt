package de.jonasheilig.challanges

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle

object BossBarManager {

    private var bossBar = Bukkit.createBossBar("", BarColor.BLUE, BarStyle.SOLID)

    fun updateBossBar(block: Material?) {
        block?.let {
            bossBar.setTitle("Find and break: $it")
            bossBar.isVisible = true
            Bukkit.getOnlinePlayers().forEach { player ->
                bossBar.addPlayer(player)
            }
        }
    }
}
