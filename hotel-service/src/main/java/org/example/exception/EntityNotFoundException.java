package org.example.exception;

import org.example.model.BaseEntity;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class<?> entityClass, String id){
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " not found!");
    }
}
