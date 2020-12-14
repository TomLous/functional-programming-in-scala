package part_06

object StrictnessLazyness {

  // Strictness and non-strictness are properties of functions.
  // When we say that a function is non-strict we are saying that perhaps the function chooses not to evaluate one or more of its arguments.
  // In contrast, a strict function always evaluates its arguments.

  // Running the unit test will show that the parameter is not substituted, but evaluated twice.
  def printTwice(f: => Int): Int = f + f

  // Exercise: fix this method to become non-strictly evaluated and only throw the error when isException is true
  def raiseException(isException: Boolean, exception: Exception): Unit = {
    if (isException) exception
  }

  // Lazy evaluation
  // Will evaluated Just in time, but only once

  def printOnce(f: => Int): Int = {
    lazy val fLazy = f
    fLazy + fLazy
  }

  lazy val dummy: Int = {
    println("This code is never evaluated, because it's never called again")
    444
  }

  // LazyList
  // Define the fibonnaci sequence as an infinite LazyList. Defining it asl list would create infinite recursive loop.

  def fibonacci(a: Long = 1L, b: Long = 1L): LazyList[Long] =
    a #:: fibonacci(b, a + b)

  // Excercise: create a LazyList using the range method from 1 until Int.MaxValue. Then cube each item in the list. Eventually this will break. But not directly
  val willBreakEventually: LazyList[Int] =
    LazyList.range(1, Int.MaxValue).map(i => i * i * i)

}
