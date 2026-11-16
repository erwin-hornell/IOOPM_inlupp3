package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Multiplication extends Binary
{
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs, rhs);
    }

    @Override 
    public double eval()
    {
        return this.lhs.eval() * this.rhs.eval();
    }
}