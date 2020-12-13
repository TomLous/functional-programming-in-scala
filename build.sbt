name := "functional-programming-in-scala"

version := "0.1.0"

scalaVersion := "2.13.4"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.19" % Test

testFrameworks += new TestFramework("munit.Framework")
