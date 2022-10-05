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
  val overseen: Vector[(I, C)]
  val actionQ: Seq[Event] = Seq.empty

  type Action = (I, C => C)


  enum Event:
    case Actions(x: Action, xs: Event) extends Event //You ever just cons-list?
    case Done extends Event

    def hasMore : Boolean = this match
      case Actions(_, _) => true
      case Done => false


  lazy val applyEvents : Overseer[I, C] => Event => Overseer[I, C] = o => { //match on Event
    case Event.Actions(x, xs) => o.overseen.find(f => x._1 == f._1) match
        case Some (id, member) => ???
        case None => applyEvents(o)(xs) //TODO: Make this return an error


    case Event.Done => o
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

