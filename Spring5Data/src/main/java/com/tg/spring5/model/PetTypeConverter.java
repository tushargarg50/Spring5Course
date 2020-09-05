package com.tg.spring5.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PetTypeConverter implements AttributeConverter<PetType, String> {

    @Override
    public String convertToDatabaseColumn(PetType petType) {
        return petType.getCode();
    }

    @Override
    public PetType convertToEntityAttribute(String s) {
        return PetType.of(s);
    }
}
