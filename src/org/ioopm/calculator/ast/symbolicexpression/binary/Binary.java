package org.ioopm.calculator.ast.symbolicexpression.binary;


import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public abstract class Binary extends SymbolicExpression
{

    protected SymbolicExpression lhs = null;
    protected SymbolicExpression rhs = null;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }


}