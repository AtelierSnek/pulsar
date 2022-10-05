package lgbt.tech.tammy
package pulsar.lib

import squants.Temperature
import squants.motion.Pressure
import squants.mass.Density
import squants.thermal._

case class Material(mPoint: Temperature, bPoint: Temperature, tensileStrength: Pressure,
                    compressiveStrength: Pressure, shearStrength: Pressure, density: Density,
                    viscosity: Double, heatCapacity: ThermalCapacity, triplePoint: Option[(Temperature,Temperature)]) {
  val sPoint: Temperature = mPoint
  val ePoint: Temperature = bPoint
}