package com.example.statistics.service

import org.springframework.stereotype.Service


data class GameResult(val totalGames: Int, val wins: Int, val losses: Int, val winPercentage: Double)

@Service
class GameStatisticsService {
    private var totalGames: Int = 0
    private var wins: Int = 0
    private var losses: Int = 0

    fun updateStatistics(isWinner: Boolean) {
        totalGames++
        if (isWinner) {
            wins++
        } else {
            losses++
        }
    }

    fun getStatistics(): GameResult {
        val winPercentage = if (totalGames > 0) (wins.toDouble() / totalGames) * 100 else 0.0
        return GameResult(totalGames, wins, losses, winPercentage)
    }
}

/*
@Service
class GameStatisticsService {

    private var wins: Int = 0
    private var losses: Int = 0

    fun updateStatistics(isWinner: Boolean) {
        if (isWinner) {
            wins++
        } else {
            losses++
        }
    }

    fun getStatistics(): GameResult {
        val totalGames = wins + losses
        val winPercentage = if (totalGames > 0) (wins.toDouble() / totalGames) * 100 else 0.0
        return GameResult(totalGames, wins, 0, losses, winPercentage)
    }
}
}*/
