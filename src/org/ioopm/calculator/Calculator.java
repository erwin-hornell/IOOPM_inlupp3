package org.ioopm.calculator;

import java.io.IOException;
import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Variable;
import org.ioopm.calculator.exceptions.IllegalAssignmentException;
import org.ioopm.calculator.exceptions.IllegalExpressionException;
import org.ioopm.calculator.exceptions.SyntaxErrorException;
import org.ioopm.calculator.parser.*;

/**
 * Calculator AST and Parser integration, main program loop.
 */
public class Calculator {

    private static int inputs = 0;
    private static int sucInputs = 0;

    private static void printVars(Environment env)
    {
        System.out.print("{");
        String vars = " ";
        for (Environment.Entry<Variable, SymbolicExpression> en : env.entrySet()) {
            Variable var = en.getKey();
            SymbolicExpression expression = en.getValue();
            vars = vars + var.getName() + " = " + expression.stringExpression() + ", ";            
        }
        if(vars.length() > 2)
        {
            vars = vars.substring(0, vars.length() - 2);

        }
        System.out.print(vars);
        System.out.println(" }");

    }
    public static void main(String[] args)
    {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();

        String input;
        SymbolicExpression result = null;
        SymbolicExpression tree = null;
        Variable ans = new Variable("ans");

        System.out.println("Welcome to the calculator!");
        System.out.println("Please enter an expression: ");

        while (true) {
            input = System.console().readLine();
            try{
                inputs++;

                tree = p.parse(input, env);
                result = tree.eval(env);

                if(result.isConstant())
                {
                    sucInputs++;
                }

            } catch(SyntaxErrorException | IllegalAssignmentException | IllegalExpressionException | IOException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
            if(result.isComand())
            {
                switch (result.getName()) {
                    case "Quit":
                        System.out.println("\nYou entered " + (inputs - 1) + " and " + (sucInputs) + " was successfully evaluated");
                        return;
                    case "Clear":
                        env.clear();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;
                    case "Vars":
                        printVars(env);
                        break;
                }
            } else { // if command, don't print its "value" (the command's name)
                env.put(ans, result);
                System.out.println(result.stringExpression());
            }
        }
    }
}

