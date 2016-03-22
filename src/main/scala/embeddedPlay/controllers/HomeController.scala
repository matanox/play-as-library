package embeddedPlay.controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

class HomeController @Inject() extends Controller {

  def index = Action {
    Ok(embeddedPlay.views.html.index("Your new application is ready."))
  }

}
