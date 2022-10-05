package lgbt.tech.tammy
package pulsar.lib

import scala.collection.IterableOnce

object IterableExtensions {
  extension [A] (i: IterableOnce[A])
    def findIndex(p: A => Boolean) :  Option[(Int,A)] = {
      val it = i.iterator
      var idx : Int = 0
      while it.hasNext do {
        val a = it.next()
        idx += 1
        if p(a) then return Some(idx,a)
      }
      None
  }
}
