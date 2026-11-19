package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

/**
 * The natural logarithm of an expression, eg ln(1), ln(e), ln(x*5+2)
 */
public class Log extends Unary
{

    public Log(SymbolicExpression exp)
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
            return new Constant(Math.log(((Constant)e).get()));
        }
        return new Log(e);
    }
    @Override 
    public String getName()
    {
        return "Log";
    }

    @Override 
    public String stringExpression()
    {
        return "Log" + expression.stringExpression();
    }
}