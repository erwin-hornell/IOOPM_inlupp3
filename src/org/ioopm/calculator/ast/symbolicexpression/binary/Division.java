package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

public class Division extends Binary
{
    public Division(SymbolicExpression lhs, SymbolicExpression rhs){
        super(lhs, rhs);
    }

    @Override 
    public SymbolicExpression eval(Environment env)
    {
        SymbolicExpression le = lhs.eval(env);
        SymbolicExpression re = rhs.eval(env);
        if(le.isComand()) return le;
        if(re.isComand()) return re;
        if(le.isConstant() && re.isConstant())
        {
            if(((Constant) re).get() == 0)
            {
                // throw exception
            }
            return new Constant( ((Constant) le).get() / ((Constant) re).get());
        }
        return new Division(le, re);
    }

    @Override 
    public String getName()
    {
        return "/";
    }

    @Override 
    public String stringExpression()
    {
        return lhs.stringExpression() + "/"  + rhs.stringExpression();
    }
}