package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public abstract class Unary extends SymbolicExpression
{
    protected SymbolicExpression expression;

    public Unary(SymbolicExpression exp)
    {
        this.expression = exp;
    }
}