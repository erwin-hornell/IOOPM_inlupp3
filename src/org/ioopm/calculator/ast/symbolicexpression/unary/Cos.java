package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

/**
 * The cosinus of an expression, eg cos(5), cos(pi), cos(-x)
 */
public class Cos extends Unary
{

    public Cos(SymbolicExpression exp)
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
            return new Constant(Math.cos(((Constant)e).get()));
        }
        return new Cos(e);
    }


    @Override 
    public String getName()
    {
        return "Cos";
    }

    @Override 
    public String stringExpression()
    {
        return "Cos" + expression.stringExpression();
    }
}