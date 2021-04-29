package part_05

object CategoryTheory {

  // [Functors]
  // We have a value and we want to apply a function to it
  val list1: List[Int] = List(1, 2, 3)
  val option1: Option[Int] = Some(4)

  val add5: Int => Int = _ + 5
  val times2: Int => Int = _ * 2

  // Every functor has a map function, that unwraps the value, applies the function and rewraps the value
  val list2: List[Int] = list1.map(add5)
  val option2: Option[Int] = option1.map(add5)

  // Ever functor  also has an identity function which returns itself
  list1.map(identity)

  // Exercise: complete the map function
  case class Container[A](content: A) {
    def map[B](f: A => B): Container[B] = Container(f(content))
  }

  // function composition
  val c1: Container[Int] = Container(34)
  val mapped1a: Container[Int] = c1.map(add5).map(times2)
  val mapped1b: Container[Int] = c1.map(add5 andThen times2)
  val mapped1c: Container[Int] = c1.map(times2 compose add5)

  // container can contain anything
  val c2: Container[List[String]] = Container(List("a", "bb", "ccc"))

  // Exercise: map each item in the List in the Container to the length of the String
  val mapped2: Container[List[Int]] = c2.map(_.map(_.length))

  // [Applicative]
  // Functor + applicative & pure methods

  val o1: Option[Int] = Option.apply(1) // in this case the apply is the `pure`

  // The applicative method depends on implementation (so there is no 1 general ap function
  def doSomething(d: Double, s: String): Int = d.toInt + s.length
  val d1: Option[Double] = Some(4.5)
  val s1: Option[String] = Some("ggg")

  val newFun: Option[String => Int] =
    d1.map(d => (s: String) => doSomething(d, s))
  // We now have an Option[String] an Option[String => Int] but not enough power to apply the Option[String] to the new function

  def ap[A, B](optF: Option[A => B]): Option[A] => Option[B] =
    optF match {
      case Some(f) =>
        (optA: Option[A]) =>
          optA match {
            case Some(a) => Some(f(a))
            case None    => None
          }
      case None => _ => None
    }

  // With this ap function  we can actually run the doSomething
  val result: Option[Int] = ap(newFun)(s1)

  // Seems a bit convoluted, but there are many helpful uses for applicative functions

  // Exercise: Implement sequenceOption to convert a List of Options into an Option of List. None when any element of the List is a None
  def sequenceOption[A](xs: List[Option[A]]): Option[List[A]] =
    xs match {
      case Nil                => Some(Nil)
      case None :: _          => None
      case Some(head) :: Nil  => Some(head :: Nil)
      case Some(head) :: tail => sequenceOption(tail).map(head :: _)
    }

  val listOpts: Option[List[Int]] = sequenceOption(
    List(Some(3), Some(5), Some(9))
  )

  // [Monad]
  // adds the flatten to an Applicative

  val o2: Option[Int] = Some(Some(1)).flatten
  val o3: Option[Nothing] = Some(None).flatten
  val l3: List[Int] = List(List(1), List(2, 3)).flatten

  // flatMap is the core of the Monad. It's map & flatten combined
  val l4: List[Int] = List(Some(1), Some(2), None, Some(3)).flatMap(_.toList)

  // Exercise: combine flatMap & map to convert a List of Strings to a list of Ints
  val l5: List[Int] =
    List("1,2", "3,4,5", "6,7").flatMap(_.split(",")).map(_.toInt)

  // [Foldable]
  // adds fold-like methods to summarize data structures

  val s2: String = List(1, 3, 4).foldLeft("") {
    case (accumulator, i) => accumulator + i.toString
  }

  val l6: List[Int] = List(List(1, 2, 3), List(4), List(5, 6, 7)).reduce(_ ++ _)

  val l7: List[Int] = List(1, 2, 3, 4).filter(_ % 2 == 0)
  val b1: Boolean = List(1, 2, 3, 4).forall(_ < 5)
  val b2: Boolean = List(1, 2, 3, 4).exists(_ % 9 == 0)
  val b3: Boolean = List(1, 2, 3, 4).isEmpty
  val l8: List[Int] = List(1, 2, 3, 4).take(2)

  // Exercise: Create a List of Ints between 0 and 100 without 7 in the number
  val noSevens: List[Int] =
    (0 until 100).toList.filterNot(_.toString.contains("7"))

}
