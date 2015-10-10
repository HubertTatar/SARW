package com.test.sarw.http.route

import akka.http.scaladsl.server.Directives._
import com.test.sarw.http.BaseServiceRoute
import com.test.sarw.http.route.directive.VersionDirective
import com.test.sarw.service.UserService
import spray.json.pimpAny

/**
 * Created by huta on 09.10.15.
 */
trait UserServiceRouteByHeader extends UserService with BaseServiceRoute with VersionDirective {
  val userRoutes2 = pathPrefix("users2") {
    pathEndOrSingleSlash {
      get {
        version {
          complete {
            //headerValueByName("version").flatMap { ver => ??? }
            //retriveFromDB().map(_.toJson)
            "OK"
          }
        }
      }
    }
  }
}

}
