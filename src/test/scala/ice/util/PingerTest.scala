package ice.util

import org.hamcrest.CoreMatchers._
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PingerTest {

  @Test
  def pingIsReachable(): Unit = {
    val ret = Pinger.ping("localhost", 100)
    assertThat("return", ret, is(true))
  }

  @Test
  def pingIsUnreachable(): Unit = {
    val ret = Pinger.ping("unreachable.example.com", 100)
    assertThat("return", ret, is(false))
  }
}
