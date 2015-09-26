package com.test.sarw.http

import com.test.sarw.http.route.UserServiceRoute
import akka.http.scaladsl.server.Directives._

trait HttpService extends UserServiceRoute {
  val routes = pathPrefix("v1") {
    usersRoute
  }
}
