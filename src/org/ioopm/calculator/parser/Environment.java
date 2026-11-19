package org.ioopm.calculator.parser;

import java.util.*;
import org.ioopm.calculator.ast.symbolicexpression.*;
import org.ioopm.calculator.ast.symbolicexpression.atom.*;

/**
 * HashMap from variable/constant name to a SymbolicExpression (some kind of value). eg x->7,
 * pi->3.141593...
 */
public class Environment extends HashMap<Variable, SymbolicExpression> {
    
}