
package idealized.scala

object true extends Boolean
{
def ifThenElse[T] (t: => T, e: => T) = t
}

object false extends Boolean
{
def ifThenElse[T] (t: => T, e: => T) = e
}

abstract class Boolean
{
  def ifThenElse[T](t: => T, e: => T): T

  // takes 2 expressions
  // if (cond) then t, else e
  // cond.ifThenElse(t, e)

  def &&(x: => Boolean): Boolean = ifThenElse(x, false)

  // if boolean itself is true, return x. otherwise, return false

  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  // if boolean itself is true, return true. otherwise, return x
  // (whatever right-hand-side operation is)

  def unary_!: Boolean = ifThenElse(false, true)

  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)

  def !=(x: Boolean): Boolean = ifThenElse(x.unary_!, x)

  def <(x: => Boolean): Boolean = ifThenElse(false, x)
}

