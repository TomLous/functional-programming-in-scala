package part_03

import part_01.ControlStructure

object SumTypes {

  // Basic Sum types
  val b1: Boolean = true
  val i1: Int = 3

  // Optional values (standard library)
  val some: Option[Int] = Some(5)
  val none: Option[Nothing] = None

  // Exercise: implement only even to return the integer wrapped in Some when even, else None
  def onlyEven(i: Int): Option[Int] = if (i % 2 == 0) Some(i) else None

  onlyEven(42) match {
    case Some(i) => println(s"$i is even")
    case None    => println(s"There was an odd number")
  }

  // Either values (standard library)
  val result1: Either[String, Int] = Right(44)
  val result2: Either[String, Int] = Left("Something went horribly wrong")

  // Exercise: implement realFactorial, using ControlStructure.factorial for the computation
  def realFactorial(n: Int): Either[String, Int] = {
    if (n < 0) Left("Factorials below 0 don't exist")
    else Right(ControlStructure.factorial(n))
  }

  realFactorial(-3) match {
    case Right(r) => println(s"The result is $r")
    case Left(l)  => println(l)
  }

}
