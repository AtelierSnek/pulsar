package lgbt.tech.tammy
package pulsar.item

import pulsar.item.*

import squants.{Length, Mass, Velocity, Volume}

enum ItemType[T]:
  case ContainerI() extends ItemType[ContainerI]
  case Ammo(ss: Int, desc: String, baseRange: Length, launchV: Velocity) extends ItemType[Ammo]



//trait Container[A <: Item] {
//  //TODO: Figure out how to make this only carry IDs
//  lazy val canContain: Iterable[A]
//  val boundBox: (Double,Double,Double)
//
//  val freeMass: Mass
//  val freeVolume: Volume
//
//  val maxMass: Mass
//  val maxVolume: Volume
//
//  val contains: Iterable[A]
//
//  val nominalMass: Mass = {
//    def f(it: Iterable[A]) : Iterable[Mass] = {
//      for (item <- it) yield item.m
//    }
//    f(contains).fold(Kilograms(0))((it: Mass, c: Mass) => it + c) //TODO: This will break due to Double bullshit
//    //Fold is preferable to foldLeft or foldRight as it's a binary fold, not linear
//  }
//}
