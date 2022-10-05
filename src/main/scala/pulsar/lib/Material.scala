package lgbt.tech.tammy
package pulsar.lib

import squants.{Temperature, Density}
import squants.thermal.ThermalCapacity
import squants.motion.Pressure

case class Material(mPoint: Temperature, bPoint: Temperature, tensileStrength: Pressure,
        compressiveStrength: Pressure, shearStrength: Pressure, density: Density,
        viscosity: Double, heatCapacity: ThermalCapacity, triplePoint: Option[(Temperature,Temperature)]) {
        val sPoint: Temperature = mPoint
        val ePoint: Temperature = bPoint
        }
