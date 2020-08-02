package fixtures

import com.h2.services.Currency
import matchers.UnitSpec

class ScalaFixtureSpec extends UnitSpec {
  behavior of "Currency Equals"

  def fixture = new {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"
  }

  it should "match two 10 USD currencies as qual when using should equal syntax" in {

    val f = fixture
    f.currency1 should equal(f.currency1)
    f.currency2 should ===(f.currency2)

  }

}
