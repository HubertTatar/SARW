package com.test.sarw.util

import com.test.sarw.model.{Order, User}
import spray.json._


//https://github.com/spray/spray-json
trait Protocol extends DefaultJsonProtocol{
  implicit val userFormat = jsonFormat3(User)
  implicit val orderFormat = jsonFormat3(Order)
}
