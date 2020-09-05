package com.tg.spring5.model;

import java.util.Arrays;

public enum PetType {

    DOG("d"), CAT("c");

    private String code;

    PetType(String code) {
        this.code = code;
    }

    public static PetType of(String s) {
        return Arrays.stream(values())
                .filter(value -> value.getCode().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getCode() {
        return code;
    }
}
