package com.ctd.bigdata

import akka.actor._
import akka.actor.ActorSystem
import akka.actor.Props


object SimpleConsumer {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("SimpleConsumer")
    val consumer = system.actorOf(Props[ConsumerActor], name ="consumer")
  }

  class ConsumerActor extends Actor {
    def receive = {
      case m: String => {
        println(s"Message is: $m")
      }
    }
  }
}