package com.test.sarw.http.route

import com.test.sarw.http.BaseServiceRoute
import com.test.sarw.service.UserService
import akka.http.scaladsl.server.Directives._
import spray.json.pimpAny

trait UserServiceRoute extends UserService with BaseServiceRoute {
  val usersRoute = pathPrefix("users"){
    pathEndOrSingleSlash {
      get{
        complete(getUsers().map(_.toJson))
      }
    }
  }
}
