package com.gelerion.combinator.parsing.expressions.arithmetic.parsing

trait ExpressionEvaluator {
  type T = Double

  //(_:String).toDouble
  val Number = (value: String) => value.toDouble
  //(_:Double) * (_:Double)
  val Mul = (a: T, b: T) => a * b
  val Div = (a: T, b: T) => a / b
  val Add = (a: T, b: T) => a + b
  val Sub = (a: T, b: T) => a - b

}
