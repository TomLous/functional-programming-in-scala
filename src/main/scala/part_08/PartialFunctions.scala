package part_08

object PartialFunctions {

  // org method
  def sum(a: Int, b: Int, c: Int): Int = a + b + c

  // Partial applied function
  val sumPartA: (Int, Int, Int) => Int = sum _

  val sumPartB: Int => Int = sum(1, 2, _)

  // partial functions as traits
  val squareRoot: PartialFunction[Int, Double] =
    new PartialFunction[Int, Double] {
      override def isDefinedAt(x: Int): Boolean = x >= 0

      override def apply(v1: Int): Double = math.sqrt(v1)
    }

  val sqrt9: Double = squareRoot(9) // 3.0
  val sqrtNeg11: Double = squareRoot(-11) // Double.NaN

  // quicker partial functions
  val divide: PartialFunction[(Int, Int), Double] = {
    case (a, b) if b != 0 => a / b.toDouble
    case _                => Double.NaN // <-- Needed for exhaustive matching
  }

  val divOk: Double = divide(12, 4)
  val divErr: Double = divide(12, 0)

  // Exercise, using non-exhausitive matches, `orElse` and `andThen` chain the (partial) functions into one chain function
  val doubleEvens: PartialFunction[Int, Int] = ???
  val tripleOdds: PartialFunction[Int, Int] = ???
  val addFive: Function1[Int, Int] = ???

  val chainAction: Int => Int = ???

}
