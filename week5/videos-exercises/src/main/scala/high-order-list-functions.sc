object session {
  def squareList1(xs: List[Int]): List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => y * y :: squareList1(ys)
    }

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  squareList1(List(1, 2, 3))
  squareList2(List(1, 2, 3))


  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => (x :: xs1.takeWhile(y => x == y)) ::
      pack(xs1.dropWhile(y => x == y))
  }

  pack(List("a", "a", "a", "b", "c", "c", "a"))

  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs).map(x => (x.head, x.length))


  encode(List("a", "a", "a", "b", "c", "c", "a"))
}
