package lgbt.tech.tammy
package pulsar.world

import pulsar.item.Item
import pulsar.world.Overseer

case object World {
  val world: Set[Overseer[?, ?]] = Set(ItemOverseer(), BodyPartOverseer())
}
