package com.rohit.thymeleaf.model.converter;

import com.rohit.thymeleaf.model.Email;
import com.rohit.thymeleaf.model.PhoneNumber;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email attribute) {
        return attribute.asString();
    }

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return new Email(dbData);
    }
}
