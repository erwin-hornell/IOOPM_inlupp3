package org.ioopm.calculator.ast.symbolicexpression;

public abstract class SymbolicExpression {
    

    public abstract double eval();


    public boolean isConstant(){ return false;}
 
}
