package lgbt.tech.tammy
package pulsar.lib


enum Event[I <: ID[_],C]:
  case Actions(x: (I, C => C), xs: Event[I,C]) extends Event[I,C] //You ever just cons-list?
  case Done extends Event

  def hasMore: Boolean = this match
    case Actions(_, _) => true
    case Done => false
