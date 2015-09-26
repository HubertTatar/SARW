package com.test.sarw.http

import akka.event.LoggingAdapter
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.stream.ActorMaterializer
import com.test.sarw.util.{Protocol, Config}

import scala.concurrent.ExecutionContext


trait BaseServiceRoute extends Protocol with SprayJsonSupport with Config {
  protected implicit def executor: ExecutionContext
  protected implicit def materializer: ActorMaterializer
  protected def log: LoggingAdapter
}
