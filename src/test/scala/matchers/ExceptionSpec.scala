package matchers

import com.h2.services.Currency

class ExceptionSpec  extends UnitSpec {

  behavior of "Currency during exception"

  it should "throw an exception when invalid number is provided in the currency string" in {
    a [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two Usd")
    an [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two Usd")
  }

  it should "provide a detailed description of exception" in {
    val exception = the [NumberFormatException] thrownBy Currency.stringToCurrency("Two USD")
    exception.getMessage should include("Two")
    exception.getMessage should equal("For input string: \"Two\"")
  }

}
