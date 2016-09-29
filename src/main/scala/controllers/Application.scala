package controllers

import play.api.mvc._

import scala.io.Source

case class Building(name: String, city: String, country: String, height: Int, floors: Int, year: Int)

class Application extends Controller {

  def index = Action {
    import java.io.File

    import scala.util.Random

    val f = new File(getClass.getClassLoader.getResource("buildings.csv").getPath)
    val bufferedSource = Source.fromFile(f)
    val buildings = bufferedSource.getLines.toList.map(line => {
      val fields = line.split(",").map(_.trim)
      Building(fields(0), fields(1), fields(2), fields(3).toInt, fields(4).toInt, fields(5).toInt)
    })
    bufferedSource.close

    Ok(views.html.index(Random.shuffle(buildings)))
  }
}
