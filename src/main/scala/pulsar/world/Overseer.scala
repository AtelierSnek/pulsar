package lgbt.tech.tammy
package pulsar.world


import pulsar.lib.{ID, IDGenerator, Overseeable, Event}
import pulsar.lib.ID.*
import pulsar.lib.IterableExtensions.findIndex
import pulsar.item.Item
import pulsar.creature.BodyPart


enum Overseer[I: ID, C]:
  case ItemOverseer(val gen: IDGenerator[ItemID], val overseen: Seq[(ItemID,Item)],
                    val actionQ: Seq[Event[ItemID,Item]] = Seq.empty)
    extends Overseer[ItemID, Item]
  case BodyPartOverseer(val gen: IDGenerator[BodyPartID], val overseen: Seq[(BodyPartID, BodyPart)],
                        val actionQ: Seq[Event[BodyPartID,BodyPart]] = Seq.empty)
    extends Overseer[BodyPartID, BodyPart]

//  def overseen: Seq[(ItemID,Item)] | Seq[(BodyPartID,BodyPart)] = this match
//    case ItemOverseer(_, o, _) => o
//    case BodyPartOverseer(_, o, _) => o

object Overseer {



}


//  lazy val applyEvents: Overseer[I, C] => Event => Overseer[I, C] = o => { //match on Event
//    case Event.Actions(x, xs) => o.overseen.findIndex(f => x._1 == f._1) match
//      case Some(idx,(id, member)) => {
//        val o_new = o match
//          case ItemOverseer() => ItemOverseer()
//          case BodyPartOverseer() => BodyPartOverseer()
//        applyEvents(o_new)(xs)
//      }
//      case None => applyEvents(o)(xs) //TODO: Make this return an error
//
//
//    case Event.Done => o
//  }