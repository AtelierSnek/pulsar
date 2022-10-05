package lgbt.tech.tammy
package pulsar.item

import pulsar.item.*

enum ItemType[T]:
  case Container() extends ItemType[Container]
  case Ammo() extends ItemType[Ammo]

