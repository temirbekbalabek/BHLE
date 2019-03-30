package lab6

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
object Student {
  case class ChangePassword(studentID: String, previousPassword: String, newPassword: String)
}
class Student extends Actor with ActorLogging{
  import Student._
  val kbtuComputer = context.actorOf(Props[KBTUComputer], "kcomputer")
  override def receive: Receive = {
    case ChangePassword(id, previousPassword, newPassword)=>
      kbtuComputer ! KBTUComputer.ChangePassword(id, previousPassword, newPassword)
  }
}
