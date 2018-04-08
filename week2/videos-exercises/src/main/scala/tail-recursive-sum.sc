object session {

  def sum(f: Int => Int, a: Int, b: Int): Int = {

    def loop(a: Int, acc: Int): Int = {
      if (a > b) return acc
      else loop(a+1, acc + f(a))
    }

    loop(a, 0)
  }

  def sum2(f: Int => Int, a: Int, b: Int): Int = {
    if (a>b)
      return 0
    else
      return  f(a) + sum(f, a+1, b);
  }
  sum(x => x, 1, 4)
}

