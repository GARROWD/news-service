package ru.garrowd.newsservice.utils.exceptions;


import ru.garrowd.newsservice.utils.exceptions.generics.GenericException;

public class NotFoundException
        extends GenericException {
    public NotFoundException(String message){
        super(message);
    }
}