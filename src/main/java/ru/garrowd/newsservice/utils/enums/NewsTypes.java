package ru.garrowd.newsservice.utils.enums;

public enum NewsTypes {
    HORIZONTAL("HORIZONTAL"),
    VERTICAL("VERTICAL");

    private final String value;

    NewsTypes(String value) {
        this.value = value;
    }
}
