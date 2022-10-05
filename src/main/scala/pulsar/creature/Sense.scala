package lgbt.tech.tammy
package pulsar.creature

import squants.{Quantity,Length}

/**
 *
 * @tparam A The Quantity over which the Sense applies. This will usually be something like Luminous Flux or SPL
 */
open case class Sense[A <: Quantity[A]](minDetectable: A, maxDetectable: A, temporaryHarm: A,
                                        permanentHarm: A){

  val minDetect: A = minDetectable
  val maxDetect: A = maxDetectable
  val tempHarm:  A = temporaryHarm
  val permHarm:  A = permanentHarm


  lazy val decay: A => Length => A = q => d => q / (d.value * d.value)

  lazy val isVisible: A => Boolean = q => {
    if q >= minDetect && q < maxDetect then true else false
  }

}