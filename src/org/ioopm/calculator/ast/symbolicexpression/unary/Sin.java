package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Sin extends Unary
{

    public Sin(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public double eval()
    {
        return Math.sin(this.expression.eval());
    }
}