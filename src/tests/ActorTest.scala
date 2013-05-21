package tests

import scala.actors.Actor

object ActorTest {

  def main(args: Array[String]): Unit = {

    val ac = new SomeActor
    ac.start
    ac !? "gg" match {
      case "xa" => println("Poluchili")
    }
    ac ! Message("Здрасти!!!")
    println("after")
  }
}

class SomeActor extends Actor {
  private var cnt = 0
  def act =
    loop {
      react {
        case Message(m) => println("Received message " + cnt + " messages:" + m)
        case _ =>
          cnt += 1
          println("Received " + cnt + " messages")
          reply("xa")
      }
    }
}

case class Message(m: String)