package org.ioopm.calculator.ast.symbolicexpression;

public abstract class SymbolicExpression {
    

    public abstract SymbolicExpression eval();


    public boolean isConstant(){ return false;}
 
}
