package org.ioopm.calculator.parser;
import java.io.IOException;
import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.exceptions.*;

/**
 * parser test
 */
class ParserDriver {
    public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();
        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: ");

        try {
            SymbolicExpression result = p.parse("1+1 = x", env);
            System.out.println("Tree: " + result.toString());
            System.out.println("result: " + result.eval(env).toString());
            SymbolicExpression result2 = p.parse("x", env);
            System.out.println("Tree: " + result2.toString());
            System.out.println("result: " + result2.eval(env).toString());
            System.err.println(env.toString());
        } catch(SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.err.println("IO Exception!");
        }
    }
}