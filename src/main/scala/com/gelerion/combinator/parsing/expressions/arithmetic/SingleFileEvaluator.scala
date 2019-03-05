package com.gelerion.combinator.parsing.expressions.arithmetic

import scala.util.parsing.combinator.JavaTokenParsers

object SingleFileEvaluator extends ArithParser with NumericAST {

  def main(args: Array[String]): Unit = {
    val expressions = args :+ "10.5 - 4*2"

    for (arg <- expressions) {
      println("input: " + arg)
      val parseResult = parseAll(expr, arg)
      println("parse result: " + parseResult)
      parseResult match {
        case Success(ast, _) =>
          println("AST: " + ast)
          println("evaluation result: " + ast.eval)
        case _ => // ignore failures
      }
    }
  }

}

trait ArithAST {
  type T

  def Add: (T, T) => T // Abstract
  def Sub: (T, T) => T // semantic
  def Mul: (T, T) => T // actions
  def Div: (T, T) => T // to build
  def Number: String => T // AST nodes.
}

trait NumericAST extends ArithAST {
  type T = Expr[Double]

  sealed abstract class Expr[+T] {def eval: T}
  case class Add(a:T, b:T) extends T {def eval = a.eval + b.eval}
  case class Sub(a:T, b:T) extends T {def eval = a.eval - b.eval}
  case class Mul(a:T, b:T) extends T {def eval = a.eval * b.eval}
  case class Div(a:T, b:T) extends T {def eval = a.eval / b.eval}
  case class Number(e:String) extends T {def eval = e.toDouble}
}

trait ArithParser extends JavaTokenParsers { this: ArithAST =>
  def expr: Parser[T]   = term * ("+" ^^^ Add | "-" ^^^ Sub)
  def term: Parser[T]   = factor * ("*" ^^^ Mul | "/" ^^^ Div)
  def factor: Parser[T] = floatingPointNumber ^^ Number | "(" ~> expr <~ ")"
}