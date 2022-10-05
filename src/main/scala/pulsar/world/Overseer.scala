package lgbt.tech.tammy
package pulsar.world


import pulsar.lib.ID
import pulsar.lib.IDGenerator
import pulsar.lib.ID.*
import pulsar.item.Item
import pulsar.creature.BodyPart

/// Structural Definitions ///
sealed abstract class Overseer[I : ID, C](){
  val gen : IDGenerator[I]
  val overseen: Iterable[(I, C)]
  val actionQ: Seq[Event] = Seq.empty

  enum Event:
    case EAction(target: I, action: C => C) extends Event
    case EDone extends Event

  //TODO: Figure out why this isn't finding stuff
//  def applyEvent[I, C](it: C, e: Event) : C = e match {
//    case EAction(t, a)  => a(it)
//    case EDone          => it
//  }
}



/// Concrete Definitions ///

case class ItemOverseer() extends Overseer[ItemID, Item] {
  val gen: IDGenerator[ItemID] = IDGenerator[ItemID](ItemID(0))
  val overseen: Vector[(ItemID, Item)] = Vector.empty
}

case class BodyPartOverseer() extends Overseer[BodyPartID, BodyPart] {
  val gen: IDGenerator[BodyPartID] = IDGenerator[BodyPartID](BodyPartID(0))
  val overseen: Vector[(BodyPartID, BodyPart)] = Vector.empty
}

