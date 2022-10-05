package lgbt.tech.tammy
package pulsar.item

import squants.{Length, Velocity}

open class Ammo(aType: ItemType.Ammo, c: Int) extends Stackable(ms = aType.ss) {

  val inStack: Int = c
  val newStack: Int => Stackable = z => Ammo(c = z, aType = aType)
}
