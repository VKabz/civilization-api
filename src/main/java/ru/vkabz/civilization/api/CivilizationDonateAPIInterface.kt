package ru.vkabz.civilization.api

import org.bukkit.Bukkit
import java.util.*

interface CivilizationDonateAPIInterface {
    fun getBalance(playerId: UUID): Int
    fun addBalance(playerId: UUID, amount: Int): Boolean
    fun deductBalance(playerId: UUID, amount: Int): Boolean
    fun getTotalDeposits(playerId: UUID): Int
    fun getTransactionHistory(playerId: UUID, limit: Int): List<Map<String, Any>>

    companion object {
        /**
         * Получает экземпляр CivilizationDonateAPIInterface из Bukkit Service Manager.
         *
         * @return CivilizationDonateAPIInterface
         * @throws IllegalStateException если API не зарегистрирован.
         */
        fun getAPI(): CivilizationDonateAPIInterface {
            return Bukkit.getServicesManager().load(CivilizationDonateAPIInterface::class.java)
                ?: throw IllegalStateException("Civilization Donate API is not registered!")
        }
    }
}
