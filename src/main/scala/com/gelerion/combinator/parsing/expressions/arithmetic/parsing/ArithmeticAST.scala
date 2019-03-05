package com.gelerion.combinator.parsing.expressions.arithmetic.parsing

trait ArithmeticAST {
  type T = Expr

  sealed trait Expr
  case class Add(a: Expr, b: Expr) extends Expr
  case class Sub(a: Expr, b: Expr) extends Expr
  case class Mul(a: Expr, b: Expr) extends Expr
  case class Div(a: Expr, b: Expr) extends Expr
  case class Number(value: String) extends Expr
}
