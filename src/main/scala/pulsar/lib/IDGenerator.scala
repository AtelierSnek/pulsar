package lgbt.tech.tammy
package pulsar.lib

import ID.*

import ID.*
import ID.given

case class IDGenerator[I : ID](c: I) {
  val curr: (I, IDGenerator[I]) = (c,IDGenerator[I](c.next))
}