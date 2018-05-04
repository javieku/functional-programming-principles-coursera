object session {
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]()) (f(_) :: _)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0) ((x, y) => y + 1 )

  lengthFun(List(1,2,3))
}