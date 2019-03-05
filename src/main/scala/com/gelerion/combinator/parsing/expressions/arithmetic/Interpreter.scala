package com.gelerion.combinator.parsing.expressions.arithmetic

import com.gelerion.combinator.parsing.expressions.arithmetic.parsing.{ArithmeticExpressionParser, ExpressionEvaluator}

object Interpreter extends ArithmeticExpressionParser with ExpressionEvaluator
