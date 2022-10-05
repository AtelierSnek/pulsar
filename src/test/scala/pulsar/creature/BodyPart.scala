package lgbt.tech.tammy
package pulsar.creature

import pulsar.creature.Sense
import pulsar.lib.Corporeal
import pulsar.lib.IDs.BodyPartID

import squants.{Mass, Volume}

open case class BodyPart(id: BodyPartID, m: Mass, v: Volume, sub: List[BodyPart] = List.empty,
                         senses: List[Sense] = List.empty)

given Corporeal[BodyPart] with
  extension(b: BodyPart)
    def mass = b.m
    def volume = b.v