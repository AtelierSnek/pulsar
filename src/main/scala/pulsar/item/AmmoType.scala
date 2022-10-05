package lgbt.tech.tammy
package pulsar.item

import squants.{Length, Velocity}


open case class AmmoType(c: Int, ss: Int, desc: String, baseRange: Length, launchV: Velocity) extends Stackable(ms = ss) {

  val inStack: Int = c
  val newStack: Int => Stackable = z => AmmoType(c = z, ss = ss, desc = desc, baseRange = baseRange, launchV = launchV)
}
