package part_10

import munit.FunSuite
import TypeVariance._

class TypeVarianceTest extends FunSuite {

  test("wasteContainers") {
    assertEquals(wasteContainer.contentType, "Paper")

    assertEquals(paperShredder.contentType, "Paper")
    assertEquals(glassContainer.contentType, "Glass")
    assertEquals(wasteBasket.contentType, "Waste")

    assertEquals(
      basicWasteBasketInsteadOfPaperBin.contentType,
      "Waste"
    ) // So the type is now Waste (moste
    assertEquals(basicWaste.contentType, "Waste")
    assertEquals(basicWasteBasketInsteadOfGlassBin.contentType, "Waste")

    assertEquals(paperBin.contentType, "Paper")
    assertEquals(glassBin.contentType, "Glass")

  }

  test("varianceOfList") {
    assertEquals(varianceOfList, "co")
  }

}
