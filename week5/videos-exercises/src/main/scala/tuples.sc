object session {

  def msort(xs : List[Int]) : List[Int] = {

    val mid = xs.length/2

    if (mid == 0) return xs
    else
    {
      val (firstMid, secondMid) = xs.splitAt(mid)

      merge(msort(firstMid), msort(secondMid))
    }
  }

  msort(List(1, 3, 10, 3, 4 ,1, 5, 6))

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, hola) => hola
    case (xs, Nil) => xs
    case (x :: xs, y :: ys) if x >= y => y :: merge(x :: xs, ys)
    case (x :: xs, y :: ys) if x < y => x :: merge(xs, y :: ys)
  }

  merge(List(1, 3, 10), List(2, 4, 6))
}