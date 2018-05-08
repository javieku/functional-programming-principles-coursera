//  1 0 2
//
//    0   1   2   3
//  |   | X |   |   |
//  |   |   |   | X |
//  | X |   |   |   |
//  |   | X |   |   |
//

object session {
  def queens(n: Int): Set[List[Int]] = {

    def isSafe(col: Int, colu   ms: List[Int]): Boolean = {
      val row = colums.length;
      val queensForRow = (0 to row - 1 by 1) zip colums;
      queensForRow forall {
        case (r, c) => c != col && math.abs(col - c) != row - r
      }
    }

    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) return Set(List())
      else {
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if (isSafe(col, queens))
        } yield col :: queens
      }
    }
    placeQueens(n)
  }

  queens(4)

}