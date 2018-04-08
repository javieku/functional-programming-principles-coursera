object session {

  class Rational(x: Int, y: Int) {

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)

    def num = x / g

    def denom = y / g

    def less(that: Rational) =
      num * that.denom < that.num * denom

    def max(that: Rational) =
      if (this.less(that)) that else this

    def add(that: Rational) =
      new Rational(num * that.denom + that.num * denom, that.denom * denom)

    override def toString = num + "/" + denom

    def neg: Rational = new Rational(-num, denom)

    def sub(that: Rational): Rational = add(that.neg)
  }

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  y.sub(z)
  x.sub(y).sub(z)

  y.sub(z)

  val one = new Rational(10, 100)
  val other = new Rational(5, 1000)

  one.add(other)
}

