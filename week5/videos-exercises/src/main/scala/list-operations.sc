object session {
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
    case List() => throw new Error("Removing from empty list")
    case y :: ys if n == 0 => ys
    case y :: ys if n > 0 => y :: removeAt(n - 1, ys)
    case _ => throw new IndexOutOfBoundsException
  }

  removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

  def flatten(xs: List[Any]): List[Any] = xs.flatten

 flatten(List(List(1, 1), 2, List(3, List(5, 8))))
}