package org.ioopm.calculator.ast.symbolicexpression.atom;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

public abstract class Atom extends SymbolicExpression
{
    private double value;

    public Atom(double value)
    {
        this.value = value;
    }

    public double get()
    {
        return this.value;
    }

    @Override
    public double eval()
    {
        return this.value;
    }


}