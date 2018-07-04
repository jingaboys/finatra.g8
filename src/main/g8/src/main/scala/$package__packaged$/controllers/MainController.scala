package $package$.controllers

import com.twitter.finagle.http.Request

import javax.inject.{Inject, Singleton}
import com.jakehschwartz.finatra.swagger.SwaggerController
import io.swagger.models.Swagger

@Singleton
class MainController @Inject()(s: Swagger) extends SwaggerController {
  implicit protected val swagger = s

  get("/:*") { request: Request =>
    response.ok.fileOrIndex(
      request.params("*"),
      "index.html")
  }

  getWithDoc("/weather.json") { o =>
    o.summary("Acquiring the weather data")
      .tag("Weather")
      .responseWith(200, "Weather data json")
  } { request: Request =>
    response.ok.json(Map("weather" -> "data"))
  }
}
