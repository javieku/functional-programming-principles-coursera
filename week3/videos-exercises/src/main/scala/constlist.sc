object session
{
  val list = new Const[Int](3, new Const[Int](3, new Nil))
}


trait List[T]
{
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(i: Int): T
}


class Nil[T] extends List[T]
{
  def isEmpty: Boolean = false

  def head = throw new NoSuchElementException("Nil.head")

  def tail = throw new NoSuchElementException("Nil.tail")

  def nth(i: Int) = throw new IndexOutOfBoundsException()
}

class Const[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false

  def nth(i: Int): T =
    if (i == 0)
      return T
    else
      return tail.nth(i - 1)
}
