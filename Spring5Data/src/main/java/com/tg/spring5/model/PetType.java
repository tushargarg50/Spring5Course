package com.tg.spring5.model;

import java.util.Arrays;

public enum PetType {

    DOG("d", 1L), CAT("c", 2L);

    private String code;

    private Long petTypeId;

    PetType(String code, Long petTypeId) {
        this.code = code;
        this.petTypeId = petTypeId;
    }

    public static PetType of(String s) {
        return Arrays.stream(values())
                .filter(value -> value.getCode().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static PetType ofId(Long id) {
        return Arrays.stream(values())
                .filter(value -> value.getPetTypeId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getCode() {
        return code;
    }

    public Long getPetTypeId() {
        return petTypeId;
    }
}
