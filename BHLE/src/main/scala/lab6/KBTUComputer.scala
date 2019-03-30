package lab6

import akka.actor.{Actor, ActorLogging, Props}

object KBTUComputer {
  case class ChangePassword(studentID: String, previousPassword: String, newPassword: String)
}
class KBTUComputer extends Actor with ActorLogging{
  import KBTUComputer._
  val kbtuDatabase = context.actorOf(Props[KBTUDatabase],"database")
  override def receive(): Receive = {

    case ChangePassword(id, previousPassword, newPassword) =>
      kbtuDatabase ! KBTUDatabase.ChangePassword(id, previousPassword, newPassword)
    case KBTUDatabase.Changed(true, id, pp, np) =>
      log.info("{} your password changed from {} to {}", id, pp, np)
    case KBTUDatabase.Changed(true, _, _, _) =>
      println("failed to change, because we can't find you in students' list")
  }
}