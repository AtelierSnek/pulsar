package lgbt.tech.tammy
package pulsar.item

import squants.{Mass, Volume}

import pulsar.lib.Corporeal

trait Item {

  lazy val v: Volume
  lazy val m: Mass

  given Corporeal[Item] with
    extension(i: Item)
      def mass = i.m
      def volume = i.v
}