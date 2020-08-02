import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {
  behavior of "Hello World"

  it should "start with the 'Hello'" in {
    assert("Hello word".startsWith("Hello"))
  }
}
