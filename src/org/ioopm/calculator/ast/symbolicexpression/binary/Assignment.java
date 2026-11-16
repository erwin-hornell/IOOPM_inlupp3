package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public class Assignment extends Binary{


    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        super(lhs, rhs);
    }

    @Override
    public double eval()
    {
        return lhs.eval();
    }
}