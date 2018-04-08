object session
{
  def product(f: Int => Int)(a: Int, b: Int) : Int =
    mapReduce(f, (x,y)=>x*y, 1) (a,b)

  product(x=>x) ( 1,3)

  def fact(n:Int) : Int = product(n=>n)(1,n)

  fact(0)

  def mapReduce(f: Int => Int, combine: (Int,Int) => Int,initVal : Int )(a: Int, b: Int) : Int =
    if (a>b) initVal
    else
      combine(f(a),mapReduce(f,combine, initVal)(a+1,b))
}