package org.ioopm.calculator.ast.symbolicexpression.binary;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Variable;
import org.ioopm.calculator.exceptions.IllegalAssignmentException;
import org.ioopm.calculator.parser.Environment;

public class Assignment extends Binary{


    public Assignment(SymbolicExpression lhs, Variable rhs)
    {
        super(lhs, rhs);
    }

    @Override 
    public SymbolicExpression eval(Environment env)
    {
        SymbolicExpression le = lhs.eval(env);
        if(le.isComand()) return le;
        if(rhs.isNamedConstant())
        {
            throw new IllegalAssignmentException("Error: cannot redefine named constant " + rhs.getName());
        }
        env.put((Variable) rhs, le);

        return le;
    }

    @Override
    public String getName()
    {
        return "=";
    }
    
    @Override 
    public String stringExpression()
    {
        return lhs.stringExpression() + "-"  + rhs.stringExpression();
    }
}