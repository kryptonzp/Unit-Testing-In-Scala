package matchers

import com.h2.services.Currency


//MatcherWords
class OrderingSpec extends UnitSpec {

  behavior of "Currency Conversion Cost in Comparison"

  it should "report equal costs for 10 USD, 10 USD" in {
    val tenUsd: Currency = "10 USD"
    val anotherTenUsd: Currency = "10 USD"

    tenUsd.costInDollars.amount should be >= anotherTenUsd.costInDollars.amount

  }

  it should "report higher costs for 100 USD, 10 USD" in {
    val tenUsd: Currency = "10 USD"
    val hunderdUsd: Currency = "100 USD"

    hunderdUsd.costInDollars.amount should be >= tenUsd.costInDollars.amount

  }


  it should "report higher costs for 1 USD < 10 USD" in {
    val oneUsd: Currency = "1 USD"
    val hunderdUsd: Currency = "100 USD"

    oneUsd.costInDollars.amount should be <= hunderdUsd.costInDollars.amount

  }

  it should "report NZD < USD" in {
    "NZD" should be < "USD"

  }


}
