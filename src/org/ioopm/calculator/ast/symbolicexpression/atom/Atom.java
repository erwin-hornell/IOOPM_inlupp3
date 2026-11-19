package org.ioopm.calculator.ast.symbolicexpression.atom;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;

/**
 * Abstract class representing an expression whose value is entirely self contained and will
 * as such be the leaf nodes of the ast. Eg x, 5, pi, -1000
 * (-1000 AFTER being evaluated as a negation!)
 */
public abstract class Atom extends SymbolicExpression
{

    
}