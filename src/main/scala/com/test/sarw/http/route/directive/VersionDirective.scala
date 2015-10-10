package com.test.sarw.http.route.directive

import akka.http.scaladsl.server.directives.{ RouteDirectives, BasicDirectives, HeaderDirectives, FutureDirectives }
import akka.http.scaladsl.server.Directive0
import akka.http.scaladsl.server.MalformedHeaderRejection

trait VersionDirective {

  import BasicDirectives._
  import HeaderDirectives._
  import RouteDirectives._
  import FutureDirectives._

  def version: Directive0 = {
    headerValueByName("version").flatMap { version =>
      version match {
        case s: String => s match {
          case "1" => pass
          case "2" => pass
          case _ => reject(MalformedHeaderRejection("version", "Wrong version"))
        }
        case _ => reject(MalformedHeaderRejection("version", "Wrong version"))
      }
    }
  }
}
