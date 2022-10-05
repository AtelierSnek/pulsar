package lgbt.tech.tammy
package pulsar.lib

import pulsar.lib.ID.*

import lgbt.tech.tammy.pulsar.lib.ID.*
import lgbt.tech.tammy.pulsar.lib.ID.given

case class IDGenerator[I : ID](c: I) {
  val curr: (I, IDGenerator[I]) = (c,IDGenerator[I](c.next))
}