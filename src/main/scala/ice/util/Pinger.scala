package ice.util

import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.sys.process._

object Pinger {
  def ping(target: String, timeout: Long = 1000): Boolean = {
    val command =
      if (System.getProperty("os.name").startsWith("Windows")) {
        List("ping", "-n", "1", "-w", String.valueOf(timeout), target)
      } else {
        List("ping", "-c", "1", "-w", String.valueOf(timeout / 1000 + 1), target)
      }

    val p = Process(command).run(ProcessLogger(_ => ()))

    val f = Future(blocking(p.exitValue()))

    try {
      Await.result(f, duration.Duration(timeout, TimeUnit.MILLISECONDS)) == 0
    } catch {
      case _: TimeoutException =>
        p.destroy()
        false
    }
  }
}
