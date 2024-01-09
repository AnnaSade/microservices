package com.example.statistics.controller

import com.example.statistics.service.GameResult
import com.example.statistics.service.GameStatisticsService
import org.springframework.web.bind.annotation.*
/*import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController*/

@RestController
@RequestMapping("/statistics")
class GameStatisticsController(private val gameStatisticsService: GameStatisticsService) {

    @GetMapping
    fun getStatistics(): GameResult {
        return gameStatisticsService.getStatistics()
    }

    @PostMapping
    fun updateStatistics(@RequestBody isWinner: Boolean) {
        if (isWinner) {
            gameStatisticsService.updateStatistics(true)
        } else {
            // Hier wird die Statistik nur aktualisiert, wenn das Spiel verloren wurde
            gameStatisticsService.updateStatistics(false)
        }
    }
}




