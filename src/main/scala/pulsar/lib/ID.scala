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


//  //Ordering instances
//  object IIDOrdering extends Ordering[ItemID]:
//    import pulsar.lib.ID.given_ID_ItemID.unID
//    def compare(x: ItemID | Null, y: ItemID | Null): Int = (x,y) match {
//      case (null, null) => 0
//      case (null, _) => -1
//      case (_, null) => +1
//      case (x: ItemID,y: ItemID) => Ordering[Int].compare(unID(x),unID(y))
//    }
////    @targetName("compare_IID")
////    def compare(x: ItemID, y: ItemID): Int = {
////      Ordering[Int].compare(unID(x),unID(y))
////    }
//
//  object BIDOrdering extends Ordering[BodyPartID]:
//    import pulsar.lib.ID.given_ID_BodyPartID.unID
//    def compare(x: BodyPartID | Null, y: BodyPartID | Null): Int = (x,y) match {
//      case (null, null) => 0
//      case (null, _) => -1
//      case (_, null) => +1
//      case (x: BodyPartID,y: BodyPartID) => Ordering[Int].compare(unID(x),unID(y))
//    }
////    @targetName("compare_BID")
////    def compare(x: BodyPartID, y: BodyPartID): Int = {
////      Ordering[Int].compare(unID(x),unID(y))
////    }
