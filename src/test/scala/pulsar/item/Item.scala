package lgbt.tech.tammy
package pulsar.item

import pulsar.lib.Corporeal
import pulsar.lib.IDs.ItemID

import squants.{Mass, Volume}

trait Item {
  val id: ItemID

  lazy val v: Volume
  lazy val m: Mass

  given Corporeal[Item] with
    extension(i: Item)
      def mass = i.m
      def volume = i.v
}
