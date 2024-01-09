import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets

class StatisticsClient {

    private val statisticsServiceUrl = "http://localhost:8080/statistics"


    fun updateStatistics(isWinner: Boolean) {
        val client = HttpClient.newHttpClient()

        // Wenn isWinner true ist, wird die Statistik als Gewinn aktualisiert, sonst als Verlust
        val request = HttpRequest.newBuilder()
            .uri(URI.create(statisticsServiceUrl))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(isWinner.toString()))
            .build()

        try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())

            if (response.statusCode() != 200) {
                println("Failed to update statistics. Response Code: ${response.statusCode()}")
            }
        } catch (e: Exception) {
            println("Failed to update statistics. Exception: ${e.message}")
        }
    }

    /*  fun updateStatistics(isWinner: Boolean) {
          val client = HttpClient.newHttpClient()

          val request = HttpRequest.newBuilder()
              .uri(URI.create(statisticsServiceUrl))
              .header("Content-Type", "application/json")
              .POST(HttpRequest.BodyPublishers.ofString(isWinner.toString()))
              .build()

          try {
              val response = client.send(request, HttpResponse.BodyHandlers.ofString())

              if (response.statusCode() != 200) {
                  println("Failed to update statistics. Response Code: ${response.statusCode()}")
              }
          } catch (e: Exception) {
              println("Failed to update statistics. Exception: ${e.message}")
          }*/



    }



/*
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class StatisticsClient {

    private val statisticsServiceUrl = "http://localhost:8080/statistics"

    fun updateStatistics(isWinner: Boolean) {
        val url = URL(statisticsServiceUrl)
        val connection = url.openConnection() as HttpURLConnection

        try {
            connection.requestMethod = "POST"
            connection.doOutput = true

            // Neuer Code: Daten schreiben
            val outputStream: OutputStream = connection.outputStream
            outputStream.write(isWinner.toString().toByteArray())
            outputStream.flush()

            if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                println("Failed to update statistics. Response Code: ${connection.responseCode}")
            }
        } finally {
            connection.disconnect()
        }
    }
}
*/
