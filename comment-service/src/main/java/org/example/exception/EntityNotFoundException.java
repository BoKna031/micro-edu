package org.example.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityClass, String property, String value){
        super("Entity " + entityClass + " with " + property + ": " + value + " not found");
    }

}
