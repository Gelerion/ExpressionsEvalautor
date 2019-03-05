package com.gelerion.combinator.parsing.expressions.arithmetic

object ArithMain {

  def main(args: Array[String]): Unit = {
    val interpreterResult = Interpreter.parseAll(Interpreter.expr, "10.5 - 4*2")
    println(s"Interpreter result: $interpreterResult") //Result: [1.11] parsed: 2.5

    val compilerResult = Compiler.parseAll(Compiler.expr, "10.5 - 4 * 2")
    println(s"Compiler result: $compilerResult")

    println()

    //path-dependant type, hence evaluator is needed
    Evaluator.parseAll(Evaluator.expr, "10.5 - 4 * 2") match {
      case Evaluator.Success(ast, _) => println(s"ast: $ast\neval: ${Evaluator.eval(ast)}")
      case _ => //ignore
    }
  }
}
