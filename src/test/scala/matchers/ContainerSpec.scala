package matchers

import com.h2.services.Currency

import scala.List

class ContainerSpec extends UnitSpec {

  behavior of "Currencies in a wallet"

  it should "contain a currency that is added to a list wallet" in {

    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"

    val wallet = List(oneUsd, twoEuros)

    wallet should contain(oneUsd)


  }

  it should "contain a currency that is added to a set wallet" in {

    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"

    val wallet = Set(oneUsd, twoEuros)

    wallet should contain(oneUsd)


  }

  it should "contain a currency that is added to a map wallet" in {

    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"


    val wallet: Map[String, Currency] = Map(
      "USD" -> oneUsd,
      "EUR" -> twoEuros
    )

    wallet should contain("USD" -> oneUsd)


  }

  it should "should not contain a currency that is not added to a map wallet" in {

    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val threeEuros: Currency = "3 EUR"

    val wallet: Map[String, Currency] = Map(
      "USD" -> oneUsd,
      "EUR" -> twoEuros
    )

    wallet should not contain("EUR" -> threeEuros)


  }

  it should "contain a one off 1  usd that is added to a set wallet" in {
    //only allows only 1
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val threeEuros: Currency = "3 EUR"


    val wallet: Set[Currency] = Set(oneUsd, twoEuros)

       wallet should contain oneOf (oneUsd,threeEuros)
    wallet should contain oneElementOf  List(oneUsd, threeEuros)



  }

  it should "not contain a one off 1  usd that is not added to a set wallet" in {
    //only allows only 1
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val threeEuros: Currency = "3 EUR"


    val wallet: Set[Currency] = Set(oneUsd,twoEuros)

    wallet should not contain (threeEuros)



  }

  it should "contain none off  usd that is added to a set wallet" in {
    //only allows only 1
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val threeEuros: Currency = "3 EUR"
    val fourEuros: Currency = "4 EUR"

    val wallet: Set[Currency] = Set(oneUsd, twoEuros)

    wallet should contain noneOf (threeEuros,fourEuros)
    wallet should contain noElementsOf  List(threeEuros,fourEuros)



  }

  it should "not contain a currency that is added to a list wallet" in {

    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"

    val wallet = List(oneUsd)

    wallet should not contain(twoEuros)


  }


}
