package matchers
import com.h2.services.CustomerService;
import org.scalatest.time.Units;
class ObjectIdentiySepc extends UnitSpec {
      val customerService: CustomerService = new CustomerService {}

      behavior of "CustomerService when creating new customers"

      it should "create " in {
          val (first,last,email,dateOfBirth) = ("Gohan","Saiyan","gohan@capsulecorp.com","1999-01-12")

          val customerId1 = customerService.createNewCustomer(first,last,email,dateOfBirth)
          val customerId2 = customerService.createNewCustomer(first,last,email,dateOfBirth)

                  val customer1 = customerService.getCustomer(customerId1).get
          val customer2 = customerService.getCustomer(customerId2).get

          customer1 should be theSameInstanceAs customer2

      }


}
