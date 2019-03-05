# Expression AST builder and Evaluator 

    $ scala SingleFileEvaluator "10.5 - 4*2"
    input: 10.5 - 4*2
    parse result: [1.11] parsed: Sub(Number(10.5),Mul(Number(4),Number(2)))
    AST: Sub(Number(10.5),Mul(Number(4),Number(2)))
    evaluation result: 2.5
    
Aims to show some scala features such as:
 - Path Dependant Types
 - Builtin Parser syntax and usage
 - Self Type Annotation (which specifies dependencies)