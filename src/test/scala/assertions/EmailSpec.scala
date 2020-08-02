package assertions

import com.h2.entities.{Dollars, Email}
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {
  behavior of "An email"

//  ignore should "return an Email object for a valid string" in {
//    val email = Email("vegeta@gmail.com")
//
//    assert(email.localPart === "z","expected localpart to be 'vegeta'")
//    assert(email.domain === "gmail.com")
//  }

//  it should "return an Email object for a valid string" in {
//    val email = Email("vegeta@gmail.com")
//
//    assert(email.localPart === "z","expected localpart to be 'vegeta'")
//    assert(email.domain === "gmail.com")
//  }

    it should "return an Email object for a valid string" in {
      val email = Email("vegeta@gmail.com")

      assert(email.localPart === "vegeta","expected localpart to be 'vegeta'")
      assert(email.domain === "gmail.com")
    }

//  it should "only allow co.za emails" in {
//    fail("Not Implemented yet")
//  }

  it should "return another email object for another valid string" in {
    assertResult("zara") {
      Email("zara@gmail.com").localPart
    }
//    fail("Test All the properties for email object")
  }

  it should "throw an exception when an email does not contain '@' symbol" in {
    assertThrows[IllegalArgumentException](Email("vegeta.com"))
  }

  it should "throw an exception when an email contains more then 1 '@' symbol" in {
    assertThrows[IllegalArgumentException](Email("vegeta@2@2.com"))
  }

  //with clue
  it should "throw an exception when an email contains more then 1 '@' symbol with clue" in {
    withClue("expected exception since email does not have '@'")
    {assertThrows[ArithmeticException](Email("vegeta@2@2.com"))}
  }

  it should "intercept the correct error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {
      Email("google.com")
    }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("invalid email: does not contain '@' symbol"))
  }

  it should "intercept the correct error message when when more than 1 '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException] {
      Email("google@vegeta@.com")
    }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("invalid email: should not contain '@' symbol more than once"))
  }



}
