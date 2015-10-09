package com.test.sarw.service

import com.test.sarw.model.Order

import scala.concurrent.{ExecutionContext, Future}


trait OrderService {
  import ExecutionContext.Implicits.global

  var map = collection.mutable.Map(1 -> Order(1, "mas@o2.pl", 2.45), 2 -> Order(2, "test@o2.pl", 6.45), 3 -> Order(3, "mas@o2.pl", 5.55))

  def retriveFromDB(): Future[Seq[Order]] = Future {
    map.values.toSeq
  }

  def retriveById(id: Int): Future[Order] = Future {
    map.get(id).get
  }

  def addToMap(email: String, amount: Double) = {
    val a = map.keysIterator.max + 1
    map.put(a, Order(a, email, amount))
  }
}