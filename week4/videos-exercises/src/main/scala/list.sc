object session {

  trait List[T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]

    def nth(i: Int): T
  }


  class Nil[T] extends List[T] {
    def isEmpty: Boolean = true

    def head = throw new NoSuchElementException("Nil.head")

    def tail = throw new NoSuchElementException("Nil.tail")

    def nth(i: Int) = throw new IndexOutOfBoundsException()

  }

  class Const[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false

    def nth(i: Int): T =
      if (i == 0)
        return head
      else
        return tail.nth(i - 1)
  }

  object List {
    def apply[T](): List[T] = new Nil

    def apply[T](x: T): List[T] = new Const(x, new Nil)

    def apply[T](x: T, y: T): List[T] = new Const(x, new Const(y, new Nil))
  }

  List()

}