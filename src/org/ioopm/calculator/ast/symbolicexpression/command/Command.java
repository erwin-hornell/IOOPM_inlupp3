package org.ioopm.calculator.ast.symbolicexpression.command;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.parser.Environment;

public abstract class Command extends SymbolicExpression
{


    @Override 
    public SymbolicExpression eval(Environment env) //what should commands evaluate to?
    {
        return this;
    }

    @Override 
    public boolean isComand()
    { 
        return true;
    }


    @Override 
    public String toString(int indent) {
        String spaces = " ".repeat(indent);

        return "{\n" +
            spaces + "  \"command\": " + getName() + ",\n" +
            spaces + "}";
    }

    @Override 
    public String stringExpression()
    {
        return "Command";
    }
}