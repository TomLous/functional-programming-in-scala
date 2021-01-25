package part_07

object ForComprehension {

  // Lets Review the Monad and it's properties
  // Let's create a Monad container called Lazy to hold unevaluated values

  class Lazy[A](value: => A) {

    private lazy val internal: A =
      value // wrapping a generic value with the monad’s context. Nothing gets evaluated

    // The flatmap is part of the Monad to apply/transform the internal value to a Monad of the same type (Lazy)
    def flatMap[B](f: (=> A) => Lazy[B]): Lazy[B] =
      f(internal)

    // A monad has the map function, since it's also a Functor. It aplies the function of the internal type and wraps it in a Lazy Monad again
    def map[B](f: A => B): Lazy[B] =
      flatMap(x => Lazy(f(x)))

    // Most Monads have a flutten function that just unnests them by calling flatmap on the identity function
    def flatten(m: Lazy[Lazy[A]]): Lazy[A] = m.flatMap(x => x)

    // Lastly if we just want the value, we call get
    def get: A = internal

    // If no result is present
    def foreach(f: A => Unit): Unit = f(internal)

  }

  // companion object with the 'apply' function to wrap the unit in the Monad
  object Lazy {
    def apply[A](value: => A): Lazy[A] = new Lazy(value)
  }

  // So now what?
  // Let's say we have these 3 monads at some point

  def getValue(i: Int): Int = {
    println(s"Evaluated $i")
    i
  }

  val lazyA1: Lazy[Int] = Lazy(getValue(1))
  val lazyA2: Lazy[Int] = Lazy(getValue(2))
  val lazyA3: Lazy[Int] = Lazy(getValue(3))

  // now let's add them into a new lazy, without evaluate them
  val lazyResultA: Lazy[Int] = lazyA1.flatMap(first =>
    lazyA2.flatMap(second => lazyA3.map(third => first + second + third))
  )

  // Although correct and nicely composable this is not very readable. Hence for comprehensions

  val lazyB1: Lazy[Int] = Lazy(getValue(11))
  val lazyB2: Lazy[Int] = Lazy(getValue(22))
  val lazyB3: Lazy[Int] = Lazy(getValue(33))

  val lazyResultB: Lazy[Int] = for {
    valB1 <- lazyB1
    valB2 <- lazyB2
    valB3 <- lazyB3
  } yield valB1 + valB2 + valB3

  // For comprehensions can also include filters
  val resultFromProcess1: Option[Int] = Some(5)
  val resultFromProcess2: Option[Int] = Some(9)
  val resultFromProcess3: Option[Int] = Some(10)

  val processAllA: Option[Int] = for {
    p1 <- resultFromProcess1
    p2 <- resultFromProcess2
    if p2 > 22
    p3 <- resultFromProcess3
  } yield p1 + p2 + p3

  val processAllB: Option[Int] = for {
    p1 <- resultFromProcess1
    p2 <- resultFromProcess2
    p3 <- resultFromProcess3
    if p3 + p1 < 16
  } yield p1 + p2 + p3

  // Exercise: filter out all combinations where the product elements from listA and listB
  // is smaller then 10 and also filter out where the sum of elements in listB and listC is smaller then 5
  // eg. (10, 10, 0) is not an element, since 10 * 10 >= 10 and (0, 4, 2) is also not an element since 4 + 2 >= 5

  val listA: List[Int] = (0 to 10).toList
  val listB: List[Int] = (0 to 10).toList
  val listC: List[Int] = (0 to 10).toList

  val result: List[(Int, Int, Int)] = Nil
//  val result: List[(Int, Int, Int)] = for{
//
//  } yield ( )

  //

}
