
package org.ioopm.calctests;

import org.ioopm.calculator.ast.symbolicexpression.SymbolicExpression;
import org.ioopm.calculator.ast.symbolicexpression.atom.Variable;
import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.parser.Environment;
public class CalculatorTests
{
    private class Test
    {
        private boolean suc;
        private String result;
        private Test(boolean suc, String result)
        {
            this.suc = suc;
            this.result = result;
        }
    }
    public static void main(String[] args) {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();

        String input;
        SymbolicExpression result = null;
        SymbolicExpression tree = null;
        Variable ans = new Variable("ans");

        
        if(testElementryFunc())
        {
            System.err.println("Elementry function Success");
        } else {
            System.err.println("Elementry function Failed");
            
        } 
        if(testNegation())
        {
            System.err.println("Negation Success");
        } else {
            System.err.println("Negation Failed");
            
        } 
        if(testUndefinedVar())
        {
            System.err.println("Undefined var Success");
        } else {
            System.err.println("Undefined var Failed");
            
        }   
        if(testVarExpression())
        {
            System.err.println("Var as expression Success");
        } else {
            System.err.println("Var as expression Failed");
            
        } 
    }

    private static boolean testVarExpression() {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();
        try {
            SymbolicExpression res = p.parse("3+x = y", env).eval(env);
            return res.stringExpression() == "3.0+x" 
                && env.get(new Variable("y")).stringExpression() == res.stringExpression();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean  testUndefinedVar() {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();
        try {
            SymbolicExpression res = p.parse("x", env).eval(env);
            return res.stringExpression() == "x";
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean testNegation() {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();
        try {
            SymbolicExpression res = p.parse("---2", env).eval(env);
            return res.stringExpression() == "-2";
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean testElementryFunc() {
        final CalculatorParser p = new CalculatorParser();
        Environment env = new Environment();
        try {
            p.parse("1/(2+8) = a", env).eval(env);

            SymbolicExpression res = p.parse("-sin(exp(a*a*10))", env).eval(env);
            return res.stringExpression() == "-0.8935409432921488";
        } catch (Exception e) {
            return false;
        }
    }
}