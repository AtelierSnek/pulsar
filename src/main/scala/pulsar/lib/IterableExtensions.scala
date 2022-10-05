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
  extension [A] (s: Seq[A])
    def dropIndex(idx: Int) : Seq[A] = {
      val left  = s.take(idx)
      val right = s.takeRight(s.size - idx - 1)
      left.concat(right)
    }
}
