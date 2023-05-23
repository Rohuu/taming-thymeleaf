package com.rohit.thymeleaf.model.converter;

import com.rohit.thymeleaf.model.PhoneNumber;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String> {
    @Override
    public String convertToDatabaseColumn(PhoneNumber attribute) {
        return attribute.asString();
    }

    @Override
    public PhoneNumber convertToEntityAttribute(String dbData) {
        return new PhoneNumber(dbData);
    }
}
