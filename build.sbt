name := "functional-programming-in-scala"

version := "0.1.0"

scalaVersion := "2.13.4"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.19" % Test
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

testFrameworks += new TestFramework("munit.Framework")
