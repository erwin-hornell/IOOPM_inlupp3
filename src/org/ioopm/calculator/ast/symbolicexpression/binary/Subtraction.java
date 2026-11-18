package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

public class Subtraction extends Binary
{
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs){
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
            return new Constant( ((Constant) le).get() - ((Constant) re).get());
        }
        return new Subtraction(le, re);
    }
    @Override 
    public String getName()
    {
        return "-";
    }
    @Override 
    public String stringExpression()
    {
        return lhs.stringExpression() + "-"  + rhs.stringExpression();
    }
}