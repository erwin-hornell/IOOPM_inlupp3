package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

/**
 * The sinus of an expression, eg sin(5), sin(pi), sin(-x)
 */
public class Sin extends Unary
{

    public Sin(SymbolicExpression exp)
    {
        super(exp);
    }

    public String getName()
    {
        return "sin";
    }
    
    @Override 
    public String stringExpression()
    {
        return "sin" + expression.stringExpression();
    }
    
    @Override 
    public SymbolicExpression eval(Environment env)
    {
        SymbolicExpression e = this.expression.eval(env);
        if(expression.isComand()) return expression;
        if(e.isConstant())
        {
            return new Constant(Math.sin(((Constant)e).get()));
        }
        return new Sin(e);
    }
}