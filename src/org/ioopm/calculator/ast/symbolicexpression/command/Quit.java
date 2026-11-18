package org.ioopm.calculator.ast.symbolicexpression.command;

public class Quit extends Command {
    private static final Quit theInstance = new Quit();
    private Quit() {}
    public static Quit instance() {
        return theInstance;
    }

    @Override
    public String getName() {
        return "Quit";
    }
    
}