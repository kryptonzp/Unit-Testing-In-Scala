package matchers

import com.h2.services.Currency


class EqualitySpec extends UnitSpec {
behavior of "Currency Equals"

  it should "match two 10 USD currencies as equal when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal (currency2)
  }

  it should "match two 10 USD currencies as === when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should === (currency2)
  }


  // cannot customize equality
  it should "match two 10 USD currencies as shouldEqual when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldEqual  currency2
  }

  // cannot customize equality
  it should "match two 10 USD currencies as shouldBe when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldBe  currency2
  }

  it should "match two 10 USD currencies as should be when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should be  (currency2)
  }

  it should "not match 10 USD & 100 USD currencies as should be when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "100 USD"

    currency1 should not be  (currency2)
  }

  it should "variation - not match 10 USD & 100 USD currencies as should be when using" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "100 USD"

    currency1 should not equal  (currency2)
  }
}
