package org.ioopm.calculator.ast.symbolicexpression.atom;

public class Constant extends Atom{

    public Constant(double value)
    {
        super(value);
    }
    
    
    @Override 
    public boolean isConstant(){
        return true;
    }
}