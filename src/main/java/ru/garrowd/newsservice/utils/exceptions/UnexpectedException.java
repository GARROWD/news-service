package ru.garrowd.newsservice.utils.exceptions;

import ru.garrowd.newsservice.utils.exceptions.generics.GenericException;

public class UnexpectedException extends GenericException {
    public UnexpectedException(String message){
        super(message);
    }
}
