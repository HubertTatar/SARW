package com.test.sarw.http.route

import com.test.sarw.http.BaseServiceRoute
import com.test.sarw.service.OrderService
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import spray.json.pimpAny

trait OrderServiceRoute extends OrderService with BaseServiceRoute {

  val orderRoutes =
    pathPrefix("orders") {
      pathEndOrSingleSlash {
        get {
          complete {
            retriveFromDB().map(_.toJson)
          }
        } ~
          post {
            parameters("email"?, "amount".as[Double]) { (email, amount) =>
              addToMap(email.getOrElse(""), amount)
              complete(StatusCodes.Accepted)
            }
          }
      } ~
        pathPrefix(IntNumber) { id =>
          pathEndOrSingleSlash {
            get {
              complete {
                retriveById(id)
              }
            }
          }
        }
    }

}
