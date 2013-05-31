import sbt._
import sbt.Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object AkkaremotetestBuild extends Build {

  lazy val akkaremotetest = Project(
    id = "akkaremotetest",
    base = file("."),
    settings = Project.defaultSettings  ++ assemblySettings ++ Seq(
      name := "AkkaRemoteTest",
      organization := "org.example",
      version := "1",
      scalaVersion := "2.10.1",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-actor" % "2.1.4" withSources,
        "com.typesafe.akka" %% "akka-remote" % "2.1.4" withSources,
        "com.typesafe.akka" %% "akka-kernel" % "2.1.4" withSources
        )
    )
  )
}
