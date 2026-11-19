package org.ioopm.calculator.ast.symbolicexpression.command;

/**
 * Command for clearing the program's environment.
 */
public class Clear extends Command {
    private static final Clear theInstance = new Clear();
    private Clear() {}
    public static Clear instance() {
        return theInstance;
    }

    @Override
    public String getName() {
        return "Clear";
    }
}