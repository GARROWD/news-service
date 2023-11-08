package ru.garrowd.newsservice.utils.exceptions;

import ru.garrowd.newsservice.utils.exceptions.generics.GenericExceptionWithDetails;
import ru.garrowd.newsservice.utils.exceptions.messages.GenericMessage;
import java.util.Set;

public class ValidationException
        extends GenericExceptionWithDetails {
    public ValidationException(Set<GenericMessage> messages) {
        super(messages);
    }
}
