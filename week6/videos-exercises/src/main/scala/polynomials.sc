object session {

  class Poly(terms0: Map[Int, Double]) {

    def this(binding: (Int, Double)*) = this(binding.toMap)

    val terms = terms0 withDefaultValue 0.0

    def +(other: Poly): Poly = new Poly((other.terms foldLeft terms) (addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + terms get exp match {
        case Some(coeff1) => exp -> (coeff + coeff1)
        case None => exp -> coeff
      }
    }

    override def toString =
      (for ((exp, coef) <- terms.toList.sorted.reverse) yield coef + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)

  p1 + p2
}