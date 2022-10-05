package lgbt.tech.tammy
package pulsar.creature

import pulsar.lib.ID.{ BodyPartID, ItemID }
import pulsar.lib.IterableExtensions.*
import pulsar.item.Item

open class Creature(parts: Seq[BodyPartID], inv: Seq[ItemID], uid: BodyPartID) {
  val addPart: BodyPartID => Creature = b => {
    Creature(parts.appended(b), inv, uid)
  }

  val removePart: BodyPartID => Creature = needle =>
    this.parts.findIndex((haystack: BodyPartID) => needle == haystack) match {
    case Some(idx,_) => Creature(parts.dropIndex(idx),inv,uid)
    case None => this
  }

  val addItem: ItemID => Creature = i => {
    Creature(parts, inv.appended(i), uid)
  }

  val removeItem: ItemID => Creature = needle => {
    this.inv.findIndex((haystack: ItemID) => needle == haystack) match {
      case Some(idx, _) => Creature(parts,inv.dropIndex(idx),uid)
      case None => this
    }
  }
}
