package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._


@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
    
  }

  def main = Action {
    Ok(views.html.table("string")) 
  }

  def form = Action {
    Ok(views.html.form("string"))
  }

  def validateLoginGet(name: String, color: String) = Action {
    Ok(s"$name logged in with $color.") 
  }

  def validateLoginPost = Action { request => 
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args => 
      val name = args("name").head
      val color = args("color").head
      Ok(s"$name logged in with $color")
    }.getOrElse(Ok("Oops"))
  }


}
