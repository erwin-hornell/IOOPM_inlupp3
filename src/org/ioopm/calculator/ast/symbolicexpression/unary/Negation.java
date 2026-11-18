package org.ioopm.calculator.ast.symbolicexpression.unary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

public class Negation extends Unary
{

    public Negation(SymbolicExpression exp)
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
            return new Constant( - ((Constant)e).get());
        }
        return new Negation(e);
    }

    @Override 
    public String getName()
    {
        return "-";
    }

    @Override 
    public String stringExpression()
    {
        return "-" + expression.stringExpression();
    }
}