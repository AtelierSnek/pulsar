package lgbt.tech.tammy
package pulsar.lib

import ID.*

import scala.annotation.targetName
import scala.deriving.*

trait ID[A]:
  extension(a: A)
    def mkID(z: Int): A
    def unID: Int
    def next: A

object ID:
  opaque type ItemID = Int
  opaque type BodyPartID = Int

  object ItemID:
    def apply(z: Int): ItemID = z

  extension (i: ItemID)
    def ItoInt: Int = i

  given ID[ItemID] with
    extension(i: ItemID)
      def mkID(z: Int) = ItemID.apply(z)
      def unID = ItoInt(i)
      def next = ItemID.apply(i.unID + 1)

  object BodyPartID:
    def apply(z: Int): BodyPartID = z

  extension (b: BodyPartID)
    def BtoInt: Int = b

  given ID[BodyPartID] with
    extension(b: BodyPartID)
      def mkID(z: Int) = BodyPartID.apply(z)
      def unID = BtoInt(b)
      def next = BodyPartID.apply(b.unID + 1)

  //CanEqual Instances
  given CanEqual[ItemID,ItemID] = CanEqual.derived
  given CanEqual[BodyPartID,BodyPartID] = CanEqual.derived
