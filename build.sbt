organization := "me.rickychang"

name := "json-gen"

version := "0.1-SNAPSHOT"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "net.liftweb" % "lift-json-ext_2.10" % "2.5.1"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.0" withSources() withJavadoc()

