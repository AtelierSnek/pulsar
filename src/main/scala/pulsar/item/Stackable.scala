package lgbt.tech.tammy
package pulsar.item

trait Stackable(ms: Int) {

  val inStack: Int
  val newStack: Int => Stackable
  lazy val splitStack: Stackable => Int => Option[(Stackable, Stackable)] = s => n => {
    if n > inStack then None else Some(newStack(n),newStack(inStack - n))
  }

  lazy val combineStacks: (Stackable, Stackable) => Option[Stackable] = (s1, s2) => {
    val total = s1.inStack + s2.inStack
    if total > ms then None else Some(newStack(total))
  }


}