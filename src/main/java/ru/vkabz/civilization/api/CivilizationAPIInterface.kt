package ru.vkabz.civilization.api

import org.bukkit.Bukkit
import java.util.*

interface CivilizationAPIInterface {
    fun getReputation(playerId: UUID): Int
    fun addReputation(playerId: UUID, amount: Int): Boolean
    fun deductReputation(playerId: UUID, amount: Int): Boolean
    fun getWarPoints(playerId: UUID): Int
    fun addWarPoints(playerId: UUID, amount: Int): Boolean
    fun deductWarPoints(playerId: UUID, amount: Int): Boolean
    fun getCivilization(playerId: UUID): String?
    fun resetCivilization(playerId: UUID): Boolean
    fun updatePlayerTab(playerId: UUID)

    companion object {
        /**
         * Получает экземпляр CivilizationAPIInterface из Bukkit Service Manager.
         *
         * @return CivilizationAPIInterface
         * @throws IllegalStateException если API не зарегистрирован.
         */
        fun getAPI(): CivilizationAPIInterface {
            return Bukkit.getServicesManager().load(CivilizationAPIInterface::class.java)
                ?: throw IllegalStateException("Civilization API is not registered!")
        }
    }
}
