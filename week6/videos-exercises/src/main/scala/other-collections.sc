object session {
  def isPrime(n: Int): Boolean = n % 1 == 0 && n % n == 0 &&
    (2 until n).forall(m => (n % m) != 0)

  isPrime(17)
  isPrime(30)
  isPrime(4)
}