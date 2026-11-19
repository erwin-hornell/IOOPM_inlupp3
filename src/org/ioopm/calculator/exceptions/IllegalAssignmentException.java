package org.ioopm.calculator.exceptions;

/**
 * RuntimeException which occurs due to an illegal assignment in the calculator, eg attempting to
 * reassign a Constant value.
 */
public class IllegalAssignmentException extends RuntimeException{
    
    public IllegalAssignmentException(String message)
    {
        super(message);
    }
}
