package de.jonasheilig.challanges

import org.bukkit.Material

class Challange1(private val plugin: Challanges) {

    private val predefinedBlocks = listOf(
        Material.STONE,
        Material.DIRT,

    )

    fun getRandomBlock(): Material {
        return predefinedBlocks.random()
    }
}
