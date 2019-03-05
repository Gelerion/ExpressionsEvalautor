package com.gelerion.combinator.parsing.expressions.arithmetic.ast.evaluator

import com.gelerion.combinator.parsing.expressions.arithmetic.parsing.ArithmeticAST

trait ArithmeticASTEvaluator extends ArithmeticAST {

  def eval(expr: Expr): Double = expr match {
    case Add(a, b) => eval(a) + eval(b)
    case Sub(a, b) => eval(a) - eval(b)
    case Div(a, b) => eval(a) / eval(b)
    case Mul(a, b) => eval(a) * eval(b)
    case Number(value) => value.toDouble
  }

}
