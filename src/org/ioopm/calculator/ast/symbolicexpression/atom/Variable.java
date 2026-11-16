package org.ioopm.calculator.ast.symbolicexpression.atom;

public class Variable extends Atom
{
    private String name;

    public Variable(double value, String name)
    {
        this.name = name;
        super(value);
    }
    
}