package matchers

import com.h2.services.CustomerService

class LengthAndSizeSpec extends UnitSpec {

  val customerService: CustomerService = new CustomerService {}

  behavior of "CustomerService for length"

  it should "return correct lenght of customer's first and last name" in {
    val (first,last,email,dateOfBirth) = ("Gohan","Saiyan","gohan@capsulecorp.com","1999-01-12")

    val customerId = customerService.createNewCustomer(first,last,email,dateOfBirth)

    val customer = customerService.getCustomer(customerId).get

    customer.first should have length first.length
    customer.last should have length last.length


  }

  behavior of "CustomerService for size"

  it should "return correct size for number of customers created" in {

    val newCustomers : Seq[(String,String,String,String)]=
      List (
        ("Vegeta","Saiyan","vegeta@capsulecorp.com","1990/02/26"),
        ("Bulma","Saiyan","bulma@capsulecorp.com","1989/12/01"),
      )


    val customerIds = newCustomers.map(newCustomers =>
      customerService.createNewCustomer(newCustomers._1,newCustomers._2,newCustomers._3,newCustomers._4)

    )

    customerIds should have size 2

  }

}
