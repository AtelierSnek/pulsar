package lgbt.tech.tammy
package pulsar.lib

object IDs:
  opaque type ItemID = Int
  opaque type BodyPartID = Int

  object ItemID:
    def apply(z: Int): ItemID = z

  extension (i: ItemID)
    def ItoInt: Int = i

  object BodyPartID:
    def apply(z: Int): BodyPartID = z

  extension (b: BodyPartID)
    def BtoInt: Int = b

