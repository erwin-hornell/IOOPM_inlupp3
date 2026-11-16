package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Sin extends Unary
{

    public Sin(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public SymbolicExpression eval()
    {
        SymbolicExpression e = this.expression.eval();
        if(e.isConstant())
        {
            return New Constant()
        }
    }
}