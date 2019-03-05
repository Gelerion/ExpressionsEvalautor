package com.gelerion.combinator.parsing.expressions.arithmetic.parsing

import scala.util.parsing.combinator.JavaTokenParsers

trait ArithmeticExpressionParser extends JavaTokenParsers {
  type T

  //PEG grammar
  lazy val expr: Parser[T]   = term * ("+" ^^^ Add | "-" ^^^ Sub)
  lazy val term: Parser[T]   = factor * ("*" ^^^ Mul | "/" ^^^ Div)
  lazy val factor: Parser[T] = floatingPointNumber ^^ Number | "(" ~> expr <~ ")"

  //semantic actions
  def Number: String => T
  def Mul: (T, T) => T
  def Div: (T, T) => T
  def Add: (T, T) => T
  def Sub: (T, T) => T

}
