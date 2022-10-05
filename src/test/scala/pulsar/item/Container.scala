package lgbt.tech.tammy
package pulsar.item

import squants.{Kilograms, Mass, Volume}
import pulsar.item.Item

trait Container[A <: Item] {
  lazy val canContain: Iterable[A]
  val boundBox: (Double,Double,Double)

  val freeMass: Mass
  val freeVolume: Volume

  val maxMass: Mass
  val maxVolume: Volume

  val contains: Iterable[A]

  val nominalMass: Mass = {
    def f(it: Iterable[A]) : Iterable[Mass] = {
      for (item <- it) yield item.m
    }
    f(contains).fold(Kilograms(0))((it: Mass, c: Mass) => it + c)
    //Fold is preferable to foldLeft or foldRight as it's a binary fold, not linear
  }
}

