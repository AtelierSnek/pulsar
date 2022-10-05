package lgbt.tech.tammy
package pulsar.world

import pulsar.item.Item
import pulsar.world.Overseer
import pulsar.world.Overseer.{BodyPartOverseer, ItemOverseer}
import pulsar.lib.ID.*
import pulsar.lib.ID.given
import pulsar.lib.{ID, IDGenerator}
import pulsar.creature.BodyPart


case class World(iO : Overseer[ID[ItemID],Item], bO : Overseer[ID[BodyPartID],BodyPart]) {
  val world: Set[Overseer[?, ?]] = Set(iO, bO)
}

