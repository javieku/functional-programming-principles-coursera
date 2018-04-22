object session
{
  trait Expr {

  }

  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr, e2:Expr) extends Expr
  case class Prod(e1:Expr, e2:Expr) extends Expr
  case class Var(n:String) extends Expr


  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
    case Prod(e1, e2) =>show(e1) + " * " + show(e2)
    case Var(n)=> n
  }

  show(Number(3))

  show(Sum(Number(123), Number(123)))

  show(Sum(Prod(Number(2), Var("x")), Var("y")))
  show(Prod(Sum(Number(2), Var("x")), Var("y")))
}