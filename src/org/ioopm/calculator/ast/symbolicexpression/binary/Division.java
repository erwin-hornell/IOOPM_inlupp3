package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Division extends Binary
{
    public Division(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs, rhs);
    }

    @Override 
    public double eval()
    {
        return this.lhs.eval() / this.rhs.eval();
    }
}