package org.ioopm.calculator.exceptions;

/**
 * RunTimeException which occurs due to unparsable input, eg inbalanced parentheses.
 */
public class SyntaxErrorException extends RuntimeException {

    public SyntaxErrorException(String message) {
        super(message);
    }
}