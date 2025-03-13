package com.bazarbozorg.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.UUID;

@Getter
@Converter(autoApply = false)
public class AutoTypeListAttributeConverter<T extends Enum<T> & TypeList<T>> implements AttributeConverter<T, UUID> {

    private final Class<T> enumClass;

    public AutoTypeListAttributeConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    // **Detects the correct TypeList enum class using reflection**
    public static <T extends Enum<T> & TypeList<T>> AttributeConverter<T, UUID> getConverterForField(Field field) {
        if (field.isAnnotationPresent(AutoTypeListConverter.class)) {
            Class<?> fieldType = field.getType();

            if (Enum.class.isAssignableFrom(fieldType) && TypeList.class.isAssignableFrom(fieldType)) {
                @SuppressWarnings("unchecked")
                Class<T> enumClass = (Class<T>) fieldType;
                return new AutoTypeListAttributeConverter<>(enumClass);
            }
        }
        throw new IllegalArgumentException("AutoTypeListConverter can only be used with TypeList enums.");
    }


    @Override
    public UUID convertToDatabaseColumn(T attribute) {
        return (attribute != null) ? attribute.getId() : null;
    }

    @Override
    public T convertToEntityAttribute(UUID dbData) {
        return (dbData != null) ? EnumCache.fromId(enumClass, dbData) : null;
    }

}
