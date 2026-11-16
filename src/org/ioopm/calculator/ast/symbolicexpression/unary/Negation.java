package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Negation extends Unary
{

    public Negation(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public double eval()
    {
        return -this.expression.eval();
    }
}