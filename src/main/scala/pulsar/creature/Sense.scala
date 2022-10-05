package lgbt.tech.tammy
package pulsar.creature

import squants.{Quantity,Length,LuminousIntensity}
import squants.photo.Lumens

/**
 *
 * @tparam A The Quantity over which the Sense applies. This will usually be something like Luminous Flux or SPL
 */
open case class Sense[A <: Quantity[A]](minDetectable: A, maxDetectable: A, temporaryHarm: A,
                                        permanentHarm: A){

  lazy val decay: A => Length => A = q => d => q / (d.value * d.value)

  lazy val isVisible: A => Boolean = q => {
    if q >= minDetectable && q < maxDetectable then true else false
  }

}