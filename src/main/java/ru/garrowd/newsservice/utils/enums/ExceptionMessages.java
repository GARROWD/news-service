package ru.garrowd.newsservice.utils.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
    NEWS_NOT_FOUND("news.error.notFound"),

    REQUEST_METHOD_NOT_SUPPORT("request.error.notSupport"),
    REQUEST_PARAMETER_CONVERT_FAILED("request.error.parameterConvertFailed"),
    REQUEST_MISSING_BODY("request.error.missingBody"),
    REQUEST_MISSING_PARAMETER("request.error.missingParameter"),
    REQUEST_ARGUMENT_NOT_VALID("request.error.requestArgumentNotValid"),

    ROOMS_AND_RECEIVERS_COUNT_MISMATCH("unexpected.error.roomsAndReceiversCuntMismatch");

    private final String value;

    ExceptionMessages(String value) {
        this.value = value;
    }
}