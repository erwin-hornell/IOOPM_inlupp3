package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

/**
 * Euler's Number to the power of an expression, eg e^3, e^pi, e^x
 */
public class Exp extends Unary
{

    public Exp(SymbolicExpression exp)
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
            return new Constant(Math.exp(((Constant)e).get()));
        }
        return new Exp(e);
    }

    @Override 
    public String getName()
    {
        return "Exp";
    }

    @Override 
    public String stringExpression()
    {
        return "Exp" + expression.stringExpression();
    }
}