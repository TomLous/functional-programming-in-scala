package part_10

import scala.reflect.runtime.universe._

object TypeVariance {

  // When dealing with OO & polymorphism a question arises:
  // if T' is a subclass of T, is Container[T'] considered a subclass of Container[T]?
  // Variance annotations allow you to express the following relationships between class hierarchies & polymorphic types:
  // Covariant
  //     C[T'] is a subclass of C[T]
  //     Scala notation: [+T]
  //
  // Contravariant
  //     C[T] is a subclass of C[T']
  //     Scala notation: [-T]
  //
  // Invariant
  //     C[T] and C[T'] are not related
  //     Scala notation: [T]

  class ContainerInvariant[A: TypeTag](val item: A) {
    val contentType: String = typeOf[A].typeSymbol.name.toString
  }

  class ContainerCovariant[+A: TypeTag](val item: A) {
    val contentType: String = typeOf[A].typeSymbol.name.toString
  }

  class ContainerContravariant[-A: TypeTag](item: A) { //Can't receive a val because it would be in a covariant position
    val contentType: String = typeOf[A].typeSymbol.name.toString
  }

  // Let's define some type hierachy
  trait Waste
  class Paper extends Waste
  class Glass extends Waste

  // If we have a Container[Waste] the only way we can assign a Container[Paper] to it is to make it Covariant.
  // So ContainerCovariant[Paper] is a subclass of ContainerCovariant[Waste]

//  val wasteContainer: ContainerInvariant[Waste] =
//    new ContainerInvariant[Paper](new Paper) <- Requires Waste

  val wasteContainer: ContainerCovariant[Waste] =
    new ContainerCovariant[Paper](new Paper)

  // The problem with covariance is that you can't mutate, set or change the object since it has to guarantee that what you put into it is a valid type.
  // In other words the reference is a waste basket, but we still have to make sure that no other waste can be placed in our paper basket.

  // Contravariance hurts the brain. How is ContainerContravariant[Waste] more specialized then ContainerContravariant[Paper]?
  // Don't think: more specialized, but focus on acceptance

  // When you have any Waste basket, it's ok to put either Glass or Paper in.

  val genericWaste = new Waste {}
  val paperWaste = new Paper()
  val glassWaste = new Glass()

  val paperShredder = new ContainerContravariant[Paper](paperWaste)
  val glassContainer = new ContainerContravariant[Glass](glassWaste)
  val wasteBasket = new ContainerContravariant[Waste](genericWaste)

  val basicWasteBasketInsteadOfPaperBin: ContainerContravariant[Paper] =
    wasteBasket
  val basicWaste: ContainerContravariant[Waste] = wasteBasket
  val basicWasteBasketInsteadOfGlassBin: ContainerContravariant[Glass] =
    wasteBasket

  val paperBin: ContainerContravariant[Paper] = paperShredder
  val glassBin: ContainerContravariant[Glass] = glassContainer

  // In scala the rule of thumb with generic types is that incoming types are contravariant and outgoing types are covariant

  trait ZIO[-R, +E, +A] // Resource goes in, Error or Type comes out

  // Exercise: set correct list & type

  class Animal
  class Dog(name: String) extends Animal

  val lassie = new Dog("Lassie")
  val champ = new Dog("Champ")
  val major = new Dog("Major")

  // If Dog <: Animal, does a List[Dog] <: List[Animal] ?

  val anAnimal: Animal = lassie
  val listAnimals: List[Animal] = ???

  val varianceOfList = ??? // "co", "contra" or "in"

  // Exercise: fix the variance correctly
  trait Vet[T] {
    def heal(animal: Animal): Boolean
  }

  def gimmeAVet() =
    new Vet[Animal] {
      override def heal(animal: Animal): Boolean = {
        println("You'll be fine!")
        true
      }
    }

  val myDogVet: Vet[Dog] = ??? //gimmeAVet()
  myDogVet.heal(champ)

}
