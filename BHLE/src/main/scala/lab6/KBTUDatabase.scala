package lab6

import akka.actor.{Actor, ActorLogging, Props}

object KBTUDatabase {
  def props: Props = Props(new KBTUDatabase)
  case class Changed(answer: Boolean, id: String, pp: String, np: String)
  case class ChangePassword(studentID: String, previousPassword: String, newPassword: String)
}
class KBTUDatabase extends Actor with ActorLogging{
  var listOfStudents = Map.empty[String, String]
  listOfStudents += "t_balabek" -> "March2019"
  override def receive: Receive = {
    case KBTUDatabase.ChangePassword(id, pp, np) =>
    if(listOfStudents.contains(id)){
      listOfStudents -= id
      listOfStudents += id -> np
      println(listOfStudents)
      sender() ! KBTUDatabase.Changed(true, id, pp, np)
    }
    else{
      sender() ! KBTUDatabase.Changed(false, id, pp, np)
    }
  }
}
