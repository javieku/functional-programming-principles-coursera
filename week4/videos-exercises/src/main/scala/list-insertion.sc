object session
{

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil
    case y :: ys =>
        if(x < y) x :: xs
        else  y :: insert(x, ys)
  }

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  isort( 1 :: 3 :: 2 :: Nil )

  isort( 10 :: 3 :: 2 :: Nil )

}