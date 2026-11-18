package org.ioopm.calculator;

import java.io.IOException;
import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.exceptions.IllegalAssignmentException;
import org.ioopm.calculator.exceptions.IllegalExpressionException;
import org.ioopm.calculator.exceptions.SyntaxErrorException;
import org.ioopm.calculator.parser.*;

public class Calculator {

    private static int inputs = 0;
    private static int sucInputs = 0;

    public static void main(String[] args)
    {
        final CalculatorParser p = new CalculatorParser();
        final Environment env = new Environment();

        String input;
        SymbolicExpression result = null;

        System.out.println("Welcome to the calculator!");
        System.out.println("Please enter an expression: ");

        while (true) {
            input = System.console().readLine();
            try{
                result = p.parse(input, env).eval(env);

                inputs++;
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
                        System.err.println("\n you entered " + (inputs - 1) + " and " + (sucInputs - 1) + " was successfully evaluated");
                        return;
                    case "Clear":
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;
                    case "Vars":
                        env.forEach((variable, expression) ->
                        System.out.println(variable.getName() + " = " + expression.stringExpression()));
                        break;
                }
            }
            System.err.println(result.stringExpression());
        }
    }
}

