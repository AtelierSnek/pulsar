package lgbt.tech.tammy
package pulsar.item

import squants.{Mass, Volume}
import pulsar.lib.{Corporeal, Overseeable}
import pulsar.lib.ID.ItemID

trait Item extends Overseeable[ItemID] {

  lazy val v: Volume
  lazy val m: Mass
  val uid: ItemID

  given Corporeal[Item] with
    extension(i: Item)
      def mass = i.m
      def volume = i.v
}