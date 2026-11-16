package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Log extends Unary
{

    public Log(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public double eval()
    {
        return Math.log(this.expression.eval());
    }
}