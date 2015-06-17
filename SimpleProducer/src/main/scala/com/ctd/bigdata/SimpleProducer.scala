package com.ctd.bigdata

import akka.actor._
import akka.actor.{ActorSystem,Props}
import akka.remote.RemoteScope

object SimpleProducer {

  // args: remoteHost remoteSystem remoteActorName
  // we assume port 11729
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("SimpleProducer")
    val worker = system.actorOf(Props(new DoWorkActor(args(0),args(1),args(2))))
    for(i <- 0 until 5) {
      worker ! SendHelloWorld
      Thread.sleep(150)
    }
    worker ! AllDone
  }

  sealed trait Message
  case object SendHelloWorld extends Message
  case object AllDone extends Message

  class DoWorkActor(host: String, remoteSystem: String, actorName: String) extends Actor {
    val uri =  s"akka.tcp://$remoteSystem@$host:11729/user/$actorName"
    val remoteActor = context.actorFor(uri)

    def receive = {
      case SendHelloWorld => {
        remoteActor ! "Hello world!"
      }
      case AllDone => {
        println("*" * 50)
        println("All messages sent...")
        println("Shutting down in 5 seconds...")
        Thread.sleep(5 * 1000)
        context.system.shutdown()
        println("*" * 50)
      }
    }
  }
}