package org.ioopm.calculator.ast.symbolicexpression.command;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public abstract class Command extends SymbolicExpression
{
    private String name;

    public Command(String name)
    {
        this.name = name;
    }

    @Override 
    public SymbolicExpression eval() //what should commands evaluate to?
    {
        return this;
    }
}