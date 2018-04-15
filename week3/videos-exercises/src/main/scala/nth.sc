
object session
{
  def nth[T](i: Int, list: List[T]) : T =
    if (i == 0)
      return list.head
    else
      return nth(i-1, list.tail)

}


