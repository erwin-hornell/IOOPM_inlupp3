package org.ioopm.calculator.ast.symbolicexpression.command;

/**
 * Command for printing all variables.
 */
public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    @Override
    public String getName() {
        return "Vars";
    }
}