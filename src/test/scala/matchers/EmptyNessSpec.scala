package matchers

import com.h2.services.{Currency, CustomerService}

class EmptyNessSpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer for emptiness"

//  it should "return empty for customer's last name " in {
//    val (first, last, email, dateOfBirth) = ("Zorro", "", "zorro@gmail.com", "1983-01-12")
//    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
//
//    val customer = customerService.getCustomer(customerId).get
//
//    println(customer)
//    customer.last should be (empty)
//    customer.last shouldBe empty
//
//  }

  behavior of "Currencies inside wallet"

  it should "be empty when no currencies are add to wallet" in {
    val wallet: List[Currency] = List.empty

    wallet should be (empty)

  }

  it should "not be empty when no currencies are add to wallet" in {
    val wallet: List[Currency] = List("1 USD")

    wallet should not be (empty)

  }
}
