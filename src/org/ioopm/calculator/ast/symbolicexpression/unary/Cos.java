package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Cos extends Unary
{

    public Cos(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public double eval()
    {
        return Math.cos(this.expression.eval());
    }
}