package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

/**
 * Abstract class. An operation which operations in respect to only one value, eg sin(val), -x,
 * ({expression}), as opposed to a binary operation eg subtraction or division.
 */
public abstract class Unary extends SymbolicExpression
{
    protected SymbolicExpression expression;

    public Unary(SymbolicExpression exp)
    {
        this.expression = exp;
    }

    @Override 
    public String toString(int indent) {
        String spaces = " ".repeat(indent);

        return "{\n" +
            spaces + "  \"operator\": \"" + getName() + "\",\n" +
            spaces + "  \"expression\": " + expression.toString(indent + 2) + ",\n" +
            spaces + "}";
    }
}