name := "Pinger"
version := "1.0.0"

scalaVersion := "2.13.3"
scalacOptions ++= Seq("-deprecation")

crossPaths := false

scalacOptions ++= Seq("-encoding", "UTF-8")

autoScalaLibrary := false

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test,
)
