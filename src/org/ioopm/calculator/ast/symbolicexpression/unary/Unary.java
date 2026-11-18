package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

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