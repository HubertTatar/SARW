package com.test.sarw.http

import com.test.sarw.http.route.{OrderServiceRoute, UserServiceRoute}
import akka.http.scaladsl.server.Directives._
import com.test.sarw.service.OrderService

trait HttpService extends UserServiceRoute with OrderServiceRoute {
  val routes = pathPrefix("v1") {
    usersRoute ~ orderRoutes
  }
}
