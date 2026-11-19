package org.ioopm.calculator.exceptions;

/**
 * RunTimeException which occurs due to an illegal expression, eg attempting to reassign a command.
 */
public class IllegalExpressionException extends RuntimeException {

    public IllegalExpressionException(String message) {
        super(message);
    }
}