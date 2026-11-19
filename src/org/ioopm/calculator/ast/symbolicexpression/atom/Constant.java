package org.ioopm.calculator.ast.symbolicexpression.atom;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.parser.Environment;

/**
 * A constant value. eg: 5, 0, 1.5, -2, etc.
 */
public class Constant extends Atom{

    private double value;

    public Constant(double value)
    {
        this.value = value;
    }
    
    @Override 
    public boolean isConstant(){
        return true;
    }

    @Override
    public SymbolicExpression eval(Environment env)
    {
        return this;
    }

    public double get()
    {
        return value;
    } 
    @Override 
    public String getName()
    {
        return Double.toString(value);
    }

    @Override 
    public String toString(int indent) {
        String spaces = " ".repeat(indent);

        return "{\n" +
            spaces + "  \"Constant\": " + get() + ",\n" +
            spaces + "}";
    }

    @Override 
    public String stringExpression()
    {
        return getName();
    }
}