package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.parser.Environment;

/**
 * A an expression encapsulated by a pair of parentheses.
 */
public class Paren extends Unary
{

    public Paren(SymbolicExpression exp)
    {
        super(exp);
    }

    @Override 
    public SymbolicExpression eval(Environment env)
    {
        SymbolicExpression e = this.expression.eval(env);
        if(expression.isComand()) return expression;
        if(e.isConstant())
        {
            return e;
        }
        return new Paren(e);
    }

    @Override 
    public String getName()
    {
        return "()";
    }

    @Override 
    public String stringExpression()
    {
        return "(" + expression.stringExpression() + ")";
    }
}