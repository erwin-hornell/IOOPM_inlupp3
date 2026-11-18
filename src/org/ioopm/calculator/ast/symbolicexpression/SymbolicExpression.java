package org.ioopm.calculator.ast.symbolicexpression;

import org.ioopm.calculator.ast.symbolicexpression.atom.Constant;
import org.ioopm.calculator.parser.Environment;

public abstract class SymbolicExpression {
    

    public abstract SymbolicExpression eval(Environment env);


    public boolean isConstant(){ return false;}
    public boolean isNamedConstant(){ return false;}
    public boolean isComand(){ return false;}

    public abstract String getName();

    public double getValue(Environment env)
    {
        SymbolicExpression e = this.eval(env);
        if(e.isConstant())
        {
            return ((Constant) e).get();
        }
        throw new RuntimeException("getValue() on expression with no clear value");
    }

    @Override
    public String toString()
    {
       return toString(0);
    }

    public abstract String stringExpression();

    public abstract String toString(int indent);
 
}
