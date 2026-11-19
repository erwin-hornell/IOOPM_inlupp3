package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

/**
 * A summation with a left-hand side value and a right-hand side value.
 */
public class Addition extends Binary
{
    public Addition(SymbolicExpression lhs, SymbolicExpression rhs){
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
            return new Constant( ((Constant) le).get() + ((Constant) re).get());
        }
        return new Addition(le, re);
    }

    

    @Override
    public String toString() {
        return super.toString();
    }

    @Override 
    public String getName()
    {
        return "+";
    }

    @Override 
    public String stringExpression()
    {
        return lhs.stringExpression() + "+"  + rhs.stringExpression();
    }
}