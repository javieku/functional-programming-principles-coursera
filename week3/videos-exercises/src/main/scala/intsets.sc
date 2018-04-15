object session {
  val t1 = new NonEmpty(5,
    new NonEmpty(3, new Empty, new Empty),
    new NonEmpty(11, new Empty, new Empty))
  val t2 = new NonEmpty(10,
    new NonEmpty(7, new Empty, new Empty),
    new NonEmpty(15, new Empty, new Empty))

  val t3 = t1 union t2

  abstract class IntSet {
    def add(x: Int): IntSet

    def contains(x: Int): Boolean

    def union(other: IntSet): IntSet
  }


  class Empty extends IntSet {
    def add(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    def contains(x: Int): Boolean = false

    def union(other: IntSet): IntSet = other

    override def toString() = "."
  }

  class NonEmpty(value: Int, left: IntSet, right: IntSet) extends IntSet {
    def add(x: Int): IntSet =
      if (x < value)
        new NonEmpty(value, left, right.add(x))
      else if (x > value)
        new NonEmpty(value, left, right.add(x))
      else this

    def contains(x: Int): Boolean =
      if (x < value)
        left.contains(x)
      else if (x > value)
        right.contains(x)
      else true

    //   5       10                5
    //  3 11    2  15   --->     3   11
    //                             10

    def union(other: IntSet): IntSet =
      ((left union right) union other) add value

    override def toString() = "{" + left + value + right + "}"

  }

}

