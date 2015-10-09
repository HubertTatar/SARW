package com.test.sarw

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.ServerSettings
import akka.http.scaladsl.{HttpsContext, Http}
import akka.stream.ActorMaterializer
import com.test.sarw.http.HttpService
import com.test.sarw.util.{MySSLConfig, Config}
import org.slf4j.LoggerFactory

import scala.concurrent.ExecutionContext

object Main extends App with Config with HttpService {
  private implicit val system = ActorSystem()

  override protected implicit val executor: ExecutionContext = system.dispatcher
  override protected val log: LoggingAdapter = Logging(system, getClass)
  override protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  //Http().bindAndHandle(routes, httpInterface, httpPort, ServerSettings(system), Option(Http().defaultClientHttpsContext))
  Http().bindAndHandle(routes, httpInterface, httpPort)
}
