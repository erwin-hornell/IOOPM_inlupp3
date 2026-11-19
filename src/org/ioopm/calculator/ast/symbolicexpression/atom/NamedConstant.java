package org.ioopm.calculator.ast.symbolicexpression.atom;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.parser.Environment;

/**
 * Variables that may not be reassigned, eg pi, e, etc. Names and values defined in parser.
 */
public class NamedConstant extends Variable {
    private double value;
    public NamedConstant(String name, double value) {
        super(name);
        this.value = value;
    }
    public double getValue()
    {
        return value;
    }
    @Override 
    public boolean isNamedConstant(){ return true;}

    @Override
    public SymbolicExpression eval(Environment env) {
        Constant con = new Constant(value);
        env.put(this, con);
        return con;
    }

    

}
