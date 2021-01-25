package part_09

object Generics {
  trait Thing
  trait Vehicle extends Thing
  class Car extends Vehicle
  class Jeep extends Car
  class Coupe extends Car
  class Motorcycle extends Vehicle
  class Bicycle extends Vehicle
  class Tricycle extends Bicycle
  class Vegetable

  // Class Parking1 takes any type A to place. Bit strange
  case class Parking1[A](place: A)

  val p1A: Parking1[Car] = Parking1(new Car)
  val p1B: Parking1[Int] = Parking1(33)
  val p1C: Parking1[Vegetable] = Parking1(new Vegetable)

  // Class Parking2 takes only cars and subclasses so no problem, but you have to recreate certain parkings for certain types. not DRY
  case class Parking2(place: Car)

  val p2A: Parking2 = Parking2(new Car)
//  val p2B: Parking2 = Parking2(Motorcycle())
  val p2C: Parking2 = Parking2(new Jeep)

  // Class Parking3 takes any type A that inherits from Vehicle
  case class Parking3[A <: Vehicle](place: A) // <: To define upper bound

  val p3A: Parking3[Car] = Parking3(new Car)
  val p3B: Parking3[Bicycle] = Parking3(new Bicycle)
//  val p3C: Parking3[Vegetable] = Parking3(new Vegetable)

  // Class Parking3 takes any type A that is at least a Jeep
  case class Parking4[A >: Jeep](place: A) // >: To define lower bound

  val p4A: Parking4[Car] = Parking4(new Car)
//  val p4B: Parking4[Bicycle] = Parking4(new Bicycle)
  val p4B: Parking4[Jeep] = Parking4(new Jeep)
  val p4C: Parking4[Thing] = Parking4(new Thing {})
//  val p4B: Parking4[Coupe] = Parking4(new Coupe)

  // Exercise: create Parking 5 so that it accepts Vehicles, Bicylces but not Tricycles

  case class Parking5[A](place: A)
  val p5A: Parking5[Vehicle] = Parking5(new Vehicle {})
  val p5B: Parking5[Bicycle] = Parking5(new Bicycle)
  val p5C: Parking5[Car] = Parking5(new Car) // <- should not work
  val p5D: Parking5[Tricycle] = Parking5(new Tricycle) // <- should not work

}
