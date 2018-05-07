object session {
  def scalarProduct(xs:List[Double], ys:List[Double]) : Double =
    (for( (x,y) <- xs zip ys ) yield { x *y }).sum

  scalarProduct(List(1,2,3),List(1,2,3))
}