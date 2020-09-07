package com.tg.spring5.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PetTypeIdConverter implements AttributeConverter<PetType, Long> {

    @Override
    public Long convertToDatabaseColumn(PetType petType) {
        return petType.getPetTypeId();
    }

    @Override
    public PetType convertToEntityAttribute(Long s) {
        return PetType.ofId(s);
    }
}
