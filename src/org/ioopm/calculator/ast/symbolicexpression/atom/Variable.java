package org.ioopm.calculator.ast.symbolicexpression.atom;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.parser.Environment;

/**
 * A variable which may have a corresponding value in an environment. Eg x, y, z, LEET
 */
public class Variable extends Atom
{
    private String name;

    public Variable(String name)
    {
        this.name = name;
    }



    @Override
    public SymbolicExpression eval(Environment env)
    {
        if(env.containsKey(this))
        {
            return env.get(this);
        }
        return this;
    }

    public String get()
    {
        return name;
    }

    @Override 
    public String getName()
    {
        return name;
    }
    
    @Override 
    public String toString(int indent) {
        String spaces = " ".repeat(indent);

        return "{\n" +
            spaces + "  \"var\": " + get() + ",\n" +
            spaces + "}";
    }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Variable)) {
            return false;
        }

        Variable other = (Variable) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override 
    public String stringExpression()
    {
        return name;
    }
}