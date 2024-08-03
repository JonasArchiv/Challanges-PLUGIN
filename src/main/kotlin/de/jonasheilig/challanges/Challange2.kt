package de.jonasheilig.challanges

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Challange2(private val plugin: Challanges) {

    private val predefinedItems = listOf(
        Material.DIAMOND,
        Material.GOLD_INGOT,
        Material.IRON_INGOT,

    )

    fun getRandomItem(): ItemStack {
        val randomMaterial = predefinedItems.random()
        return ItemStack(randomMaterial, 1)
    }
}
