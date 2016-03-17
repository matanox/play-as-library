package embeddedPlay;
import java.io.File

import play.api.{Application, Environment, ApplicationLoader}
import play.api.mvc.{RequestHeader, Result}
import play.core.{SourceMapper, WebCommands, HandleWebCommandSupport, BuildLink}

object Server {
  
  class Dummy 

  def startWebServer = {
    val environment = new Environment(
      new File("."),
      classOf[Dummy].getClassLoader,
      play.api.Mode.Dev
    )

    val sourceMapper: Option[SourceMapper] = None
    
    val context = play.api.ApplicationLoader.createContext(environment)
    val application = ApplicationLoader(context).load(context)

    play.api.Play.start(application)

    play.core.server.NettyServer.fromApplication(application)
  }
}