package part_01

import scala.annotation.tailrec

object ControlStructure {

  // Sample methods
  def square(x: Double): Double = x * x

  def cube(x: Int): Int = x * x * x

  // Exercise: Complete method with basic if/else
  def abs(x: Double): Double = ???

  // Exercise: Complete method with basic recursion
  def factorial(n: Int): Int = ???

  // Exercise: Complete method and inner methods
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      ???

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      abs(square(guess) - x) < 0.001

    sqrtIter(1.0, x)
  }

  // Advanced Exercise: make sure that sqrtIter is @tailrec
}
