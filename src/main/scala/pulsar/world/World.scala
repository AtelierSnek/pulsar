package lgbt.tech.tammy
package pulsar.world

import pulsar.item.Item
import pulsar.world.Overseer
import pulsar.world.Overseer.{BodyPartOverseer, ItemOverseer}
import pulsar.lib.ID.*
import pulsar.lib.ID.given
import pulsar.lib.IDGenerator
import pulsar.creature.BodyPart


case class World(iO : Overseer[ItemID,Item], bO : Overseer[BodyPartID,BodyPart]) {
  val world: Set[Overseer[?, ?]] = Set(iO, bO)
}

