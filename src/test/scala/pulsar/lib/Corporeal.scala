package lgbt.tech.tammy
package pulsar.lib


import squants.{Mass, Volume}

/**
 * @note Corporeal objects are those with a discrete weight and volume
 *
 */

trait Corporeal[A] {
  extension (a: A)
    def mass: Mass
    def volume: Volume
}
