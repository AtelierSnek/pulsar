package lgbt.tech.tammy
package pulsar

import pulsar.world.{Overseer, World}
import pulsar.lib.IDGenerator
import pulsar.lib.ID.*
import pulsar.lib.ID.given

@main
def main(): Unit = {
  val iO = Overseer.ItemOverseer(new IDGenerator[ItemID](ItemID(0)),Seq.empty)
  val bO = Overseer.BodyPartOverseer(new IDGenerator[BodyPartID](BodyPartID(0)),Seq.empty)
  var w = World(iO, bO)
  println("Hello world!")

}