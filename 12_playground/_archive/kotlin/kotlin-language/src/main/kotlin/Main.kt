import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(args: Array<String>) {
    println("Hello World!")

    val httpClient = HttpClient.newHttpClient()
    val uri = URI.create("https://de.wikipedia.org/")
    val httpRequest = HttpRequest.newBuilder(uri).GET().build()

    val response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString())

    println(response)
}