package lgbt.tech.tammy
package pulsar.world


import pulsar.lib.{Event, ID, IDGenerator, Overseeable}
import pulsar.lib.ID.*
import pulsar.lib.IterableExtensions.findIndex
import pulsar.item.Item
import pulsar.creature.BodyPart

import math.Ordered.orderingToOrdered
import math.Ordering.Implicits.infixOrderingOps


enum Overseer[I <: ID[_], C]:
  case ItemOverseer(val gen: IDGenerator[ItemID], val overseen: Seq[(ItemID,Item)],
                    val actionQ: Seq[Event[ItemID,Item]] = Seq.empty)
    extends Overseer[ID[ItemID], Item]
  case BodyPartOverseer(val gen: IDGenerator[BodyPartID], val overseen: Seq[(BodyPartID, BodyPart)],
                        val actionQ: Seq[Event[BodyPartID,BodyPart]] = Seq.empty)
    extends Overseer[ID[BodyPartID], BodyPart]


  //Type Aliases for Convenience
  type OverseerI    = Overseer[ID[ItemID], Item]        | Overseer[ID[BodyPartID], BodyPart]
  type IDGeneratorI = IDGenerator[ItemID]               | IDGenerator[BodyPartID]
  type OverseenI    = Seq[(ID[ItemID], Item)]           | Seq[(ID[BodyPartID], BodyPart)]
  type EventI       = Event[BodyPartID, BodyPart]       | Event[ItemID, Item]
  type ActionQI     = Seq[Event[BodyPartID, BodyPart]]  | Seq[Event[ItemID, Item]]


  //Boilerplate Extractors
  val genI: IDGeneratorI = this match {
    case ItemOverseer(g, _, _) => g
    case BodyPartOverseer(g, _, _) => g
  }

  val overseenI: OverseenI = this match {
    case ItemOverseer(_, o, _) => o
    case BodyPartOverseer(_, o, _) => o
  }

  val actionQI: ActionQI = this match {
    case ItemOverseer(_, _, a) => a
    case BodyPartOverseer(_, _, a) => a
  }

  lazy val applyEvents: OverseerI => Event[I,C] => OverseerI = o => { //match on Event
    case Event.Actions(x, xs) => o.overseenI.findIndex(f => x._1 == f._1) match
      case Some(idx, (id, member)) =>
        val o_new: OverseerI = o match
          case ItemOverseer(g, o, a) => ItemOverseer(g, o, a)
          case BodyPartOverseer(g, o, a) => BodyPartOverseer(g, o, a)
        applyEvents(o_new)(xs)
      case None => applyEvents(o)(xs) //TODO: Make this return an error

    case Event.Done => o
  }

object Overseer {
//  if (ItemID(3) < ItemID(4)) then {
//
//  }

}

