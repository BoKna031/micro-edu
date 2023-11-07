package org.example.exception;

public class UniqueConstraintException extends RuntimeException{
    public UniqueConstraintException(String property, String value){
        super(property + " " + value + " already exists");
    }
}
