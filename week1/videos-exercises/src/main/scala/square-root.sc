object session {

  def abs(d: Double): Double = if (d >= 0) d else -d


  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess))
        guess
      else
        sqrtIter(improveGuess(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improveGuess(guess: Double): Double =
      guess + ((x / guess) - guess) / 2

    sqrtIter(1)
  }


  sqrt(2)
  sqrt(4)
  sqrt(1e-6)
  sqrt(0.1e-20)
  sqrt(1e20)
  sqrt(1e50)

}