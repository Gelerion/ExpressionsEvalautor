package com.gelerion.combinator.parsing.expressions.arithmetic

import com.gelerion.combinator.parsing.expressions.arithmetic.ast.evaluator.ArithmeticASTEvaluator
import com.gelerion.combinator.parsing.expressions.arithmetic.parsing.{ArithmeticAST, ArithmeticExpressionParser}

object Evaluator extends ArithmeticExpressionParser with ArithmeticAST with ArithmeticASTEvaluator

