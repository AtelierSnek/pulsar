package lgbt.tech.tammy
package pulsar.lib

import ID.*

import scala.annotation.targetName
import scala.deriving.*

import math.Ordered.orderingToOrdered
import math.Ordering.Implicits.infixOrderingOps

enum ID[I]:
  case ItemID(id: Int) extends ID[ItemID]
  case BodyPartID(id: Int) extends ID[BodyPartID]

  //Ordering instances

object IDOrdering extends Ordering[ID[_]]:
  def compare(x: ID[_], y: ID[_]): Int = (x, y) match {
    case (ItemID(x), ItemID(y)) => Ordering[Int].compare(x,y)
    case (BodyPartID(x), BodyPartID(y)) => Ordering[Int].compare(x,y)
    case (_ , _) => ??? //Scream and yell
  }
