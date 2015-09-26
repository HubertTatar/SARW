package com.test.sarw.service

import com.test.sarw.model.User

import scala.concurrent.{ExecutionContext, Future}

trait UserService {

  import ExecutionContext.Implicits.global

  def getUsers(): Future[Seq[User]] = Future {
    Seq(User(1, "John", "secret"))
  }
}
