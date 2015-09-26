package com.test.sarw.util

import com.test.sarw.model.User
import spray.json._
import DefaultJsonProtocol._

trait Protocol extends DefaultJsonProtocol{
  implicit val userFormat = jsonFormat3(User)
}
