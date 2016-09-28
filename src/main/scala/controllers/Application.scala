package controllers

import play.api.mvc._

case class Building(name: String, height: Int, city: String)

class Application extends Controller {

  def index = Action {

    val buildings = List(
      Building("Burj Khalifa", 830, "Dubai"),
      Building("Tokyo Skytree", 634, "Tokyo")
    )

    Ok(views.html.index(buildings))
  }
}
