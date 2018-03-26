package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0)
        1
      else if (c == r)
        1
      else
        pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean =
    {
      def balance_impl(acc: String, chars: List[Char]): Boolean =
      {
        if (chars.isEmpty)
          acc.isEmpty
        else if (chars.head.equals('('))
          balance_impl(acc + "(", chars.tail)
        else if (chars.head.equals(')'))
          if(acc.isEmpty)
            false
          else
            balance_impl(acc.dropRight(1), chars.tail)
        else
          balance_impl(acc, chars.tail)
      }

      balance_impl("", chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
