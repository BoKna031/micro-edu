package org.example.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityClass, String property, String value){
        super("Entity " + entityClass + " with " + property + ": " + value + " not found");
    }

    public EntityNotFoundException(String entityName, String property, String value){
        super(entityName + " with " + property + ": " + value + " not found");
    }

    public EntityNotFoundException(String msg){
        super(msg);
    }

}
