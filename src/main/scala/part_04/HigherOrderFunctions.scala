package part_04

import part_01.ControlStructure._

object HigherOrderFunctions {

  // Take these functions
  def sumIntsBasic(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumIntsBasic(a + 1, b)

  def sumFactorialsBasic(a: Int, b: Int): Int =
    if (a > b) 0 else factorial(a) + sumFactorialsBasic(a + 1, b)

  def sumCubesBasic(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubesBasic(a + 1, b)

  // Using this Higher Order Function (it takes a function as parameter)
  // The type A => B is the type of a function that takes an argument of type A and returns a result of type B.
  // Exercise: complete this method
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else ???

  // We can rewrite the first methods
  def id(x: Int): Int = x
  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
  def sumFactorials(a: Int, b: Int): Int = sum(factorial, a, b)

  // We can also create anonymous functions this way
  def sumSquares(a: Int, b: Int): Int = sum(x => x * x, a, b)

}
