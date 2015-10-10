package com.test.sarw.service

import com.test.sarw.model.User
import org.slf4j.LoggerFactory

import scala.concurrent.{ExecutionContext, Future}

trait UserService {
  val logger = LoggerFactory.getLogger(classOf[UserService])

  import ExecutionContext.Implicits.global

  def getUsers(): Future[Seq[User]] = Future {
    Seq(User(1, "John", "secret"))
  }

  def getUsers(version: String): Future[Seq[User]] = Future {
    Seq(User(1, "John", "secret"))
  }

  def getUserById(id: Int): Future[User] = Future {
    User(1, "John", "secret")
  }

  def updateUser(id: Int, user: User): Future[User] = Future {
    user
  }

  def createUser(user: User): Future[User] = Future {
    User(2, "John", "secret")
  }

  def deleteUser(id: Int) = Future {
    logger.info(s"Removing $id")
    true
  }
}
