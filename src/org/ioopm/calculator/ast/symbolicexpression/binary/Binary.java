package org.ioopm.calculator.ast.symbolicexpression.binary;


import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

/**
 * A value which depends on evaluating a left-hand side value with respect to a right-hand side value.
 * Eg addition or multiplication.
 */
public abstract class Binary extends SymbolicExpression
{

    protected SymbolicExpression lhs;
    protected SymbolicExpression rhs;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override 
    public String toString(int indent) {
        String spaces = " ".repeat(indent);

        return "{\n" +
            spaces + "  \"operator\": \"" + getName() + "\",\n" +
            spaces + "  \"lhs\": " + lhs.toString(indent + 2) + ",\n" +
            spaces + "  \"rhs\": " + rhs.toString(indent + 2) + "\n" +
            spaces + "}";
    }

}