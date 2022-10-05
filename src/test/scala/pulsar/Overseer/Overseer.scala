package lgbt.tech.tammy
package pulsar.Overseer

import pulsar.lib.*
import pulsar.lib.ID.{BodyPartID, ItemID}



abstract class Overseer[I : ID](){
  val gen : IDGenerator[I]
}


case class ItemOverseer() extends Overseer[ItemID] {
  val gen: IDGenerator[ItemID] = IDGenerator[ItemID](ItemID(0))
}

case class BodyPartOverseer() extends Overseer[BodyPartID] {
  val gen: IDGenerator[BodyPartID] = IDGenerator[BodyPartID](BodyPartID(0))

}