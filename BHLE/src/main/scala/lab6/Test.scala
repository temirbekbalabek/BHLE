package lab6

import akka.actor.{ActorSystem, Props}
import com.sun.tracing.Probe

import scala.io.StdIn
object Test extends App {
  val system = ActorSystem("test")
  val student = system.actorOf(Props[Student], "student")
  student ! Student.ChangePassword("t_balabek","March2019","April2019")
  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()
}
