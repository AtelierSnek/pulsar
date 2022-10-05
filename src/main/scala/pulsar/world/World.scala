package lgbt.tech.tammy
package pulsar.world

import pulsar.item.Item
import pulsar.world.Overseer
import pulsar.world.Overseer.{BodyPartOverseer, ItemOverseer}
import pulsar.lib.ID.*
import pulsar.lib.ID.given
import pulsar.lib.IDGenerator


case class World(iO : ItemOverseer, bO : BodyPartOverseer) {
//  private val iO = Overseer.ItemOverseer(new IDGenerator[ItemID](ItemID(0)),Seq.empty)
//  private val bO = Overseer.BodyPartOverseer(new IDGenerator[BodyPartID](BodyPartID(0)),Seq.empty)
  val world: Set[Overseer[?, ?]] = Set(iO, bO)
}

