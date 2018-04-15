
object session
{
  def nth[T](i: Int, list: List[T]) : T =

    if (list.isEmpty || i < 0) throw new IndexOutOfBoundsException()
    if (i == 0)
      return list.head
    else
      return nth(i-1, list.tail)

}


