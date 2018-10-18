name := "logger"

version := "0.1"

scalaVersion := "2.12.7"

resolvers += Resolver.jcenterRepo
resolvers += Resolver.DefaultMavenRepository



libraryDependencies ++= Seq(
  //JDA
  "net.dv8tion" % "JDA" % "3.8.0_436",
  // Logger
  "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
  // Logging impl
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.11.1",
  // Logging api
  "org.apache.logging.log4j" % "log4j-api" % "2.11.1",
)