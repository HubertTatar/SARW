package com.test.sarw.http.route

import akka.http.scaladsl.model.StatusCodes
import com.test.sarw.http.BaseServiceRoute
import com.test.sarw.model.User
import com.test.sarw.service.UserService
import akka.http.scaladsl.server.Directives._
import spray.json.pimpAny

trait UserServiceRoute extends UserService with BaseServiceRoute {
  val usersRoute = pathPrefix("users"){
    pathEndOrSingleSlash {
      get{
        complete(getUsers().map(_.toJson))
      }
    } ~
    pathPrefix(IntNumber){ id =>
      pathEndOrSingleSlash {
        get {
          complete(getUserById(id).map(_.toJson))
        } ~
        post {
          entity(as[User]) { userUpdate =>
            complete(updateUser(id, userUpdate).map(_.toJson))
          }
        } ~
        delete {
            onSuccess(deleteUser(id)){ ignored =>
              complete(StatusCodes.NoContent)
          }
        }
      }
    }
  }
}
