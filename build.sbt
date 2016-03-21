
import play.twirl.sbt.SbtTwirl
import play.twirl.sbt.Import.TwirlKeys

/* a test application for the application */
lazy val app = (project in file("."))
  .enablePlugins(SbtTwirl).settings(
    scalaVersion := "2.11.7",
    name:= "play-as-library",
    libraryDependencies ++= Seq(
      /* play framework as a library */
      "com.typesafe.play" %% "play" % "2.4.6",
      "com.typesafe.play" %% "play-netty-server" % "2.4.6",
      /* json */
      "com.typesafe.play" %% "play-json" % "2.4.6"
      /* http client */
    ),
    javaOptions in run += "-Dhttp.port=9999",
    sourceDirectories in (Compile, TwirlKeys.compileTemplates) := (unmanagedSourceDirectories in Compile).value
  )

TwirlKeys.templateImports += "play.api.templates.PlayMagic._"
TwirlKeys.templateImports += "views.html.play20" // This is necessary since views package is not in the root directory of the project
