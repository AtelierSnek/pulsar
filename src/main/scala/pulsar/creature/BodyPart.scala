package lgbt.tech.tammy
package pulsar.creature

import squants.{Mass, Volume}
import pulsar.lib.ID.BodyPartID
import pulsar.creature.Sense
import pulsar.lib.Corporeal

open case class BodyPart(id: BodyPartID, m: Mass, v: Volume, sub: Vector[BodyPart] = Vector.empty,
                         senses: Vector[Sense[?]] = Vector.empty)

given Corporeal[BodyPart] with
  extension(b: BodyPart)
    def mass = b.m
    def volume = b.v