package lab5.lab1
import akka.actor.{Actor, ActorSystem, Props}
import lab5.lab1.second.system

import scala.io.StdIn

class SupervisingActor extends Actor {
  val child = context.actorOf(SupervisedActor.props, "supervised-actor")

  override def receive: Receive = {
    case "failChild" ⇒ child ! "fail"
  }
}

object SupervisedActor {
  def props: Props =
    Props(new SupervisedActor)
}

object SupervisingActor {
  def props: Props =
    Props(new SupervisingActor)
}

class SupervisedActor extends Actor {
  override def preStart(): Unit = println("supervised actor started")
  override def postStop(): Unit = println("supervised actor stopped")

  override def receive: Receive = {
    case "fail" ⇒
      println("supervised actor fails now")
      throw new Exception("I failed!")
  }
}

object third extends App {
  val system = ActorSystem("testsystem")
  val supervisingActor = system.actorOf(SupervisingActor.props, "supervising-actor")
  supervisingActor ! "failChild"
  try StdIn.readLine()
  finally system.terminate()
}
