package matchers

import com.h2.services.CustomerService

class StringSpec extends UnitSpec {

  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer Service for Strings"

  it should "correct match the customer email starting with the first name" in {
    val (first, last, email, dateOfBirth) = ("Vegeta", "Saiyan", "vegeta@gmail.com", "1990/12/26")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should startWith(first.toLowerCase())


  }

  it should "correct match the customer email ending with .com " in {
    val (first, last, email, dateOfBirth) = ("Vegeta", "Saiyan", "vegeta@gmail.com", "1990/12/26")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should endWith(".com")


  }


  //  it should "correct match the customer includes @symbol " in {
  //    val(first,last,email,dateOfBirth)= ("Vegeta","Saiyan","vegeta@gmail.com","1990/12/26")
  //
  //    val customerId = customerService.createNewCustomer(first,last,email,dateOfBirth)
  //    val customer = customerService.getCustomer(customerId).get
  //
  //    customer.email.toString should include("@")
  //
  //
  //  }

  it should "correct match the customer includes @symbol " in {
    val (first, last, email, dateOfBirth) = ("Vegeta", "Saiyan", "vegeta@gmail.com", "1990/12/26")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should include regex "[a-z]+[@.]com"

  }

  it should "correct match the customer dateOfBirth as fullyMatch regula rexpression " in {
    val (first, last, email, dateOfBirth) = ("Vegeta", "Saiyan", "vegeta@gmail.com", "1990/12/26")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.dateOfBirth.toString should fullyMatch regex """[0-9]{4}-[0-9]{2}-[0-9]{2}"""

  }

}
