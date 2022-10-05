package lgbt.tech.tammy
package pulsar.lib

import ID.*
import ID.given
case class IDGenerator[I <: ID[_]](c: ID[_]) {
  val curr: (Int, IDGenerator[I]) = c match {
    case ItemID(i) => (i,IDGenerator[I](ItemID(i + 1)))
    case BodyPartID(b) => (b,IDGenerator[I](BodyPartID(b + 1)))
  }
}