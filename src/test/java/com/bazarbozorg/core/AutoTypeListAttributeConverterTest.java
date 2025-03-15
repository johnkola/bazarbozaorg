package com.bazarbozorg.core;

import com.bazarbozorg.enums.AutoTypeListAttributeConverter;
import com.bazarbozorg.enums.RoleTypeList;
import com.bazarbozorg.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AutoTypeListAttributeConverterTest {

    private static AutoTypeListAttributeConverter<RoleTypeList> roleConverter;

    @BeforeAll
    static void setup() {
        roleConverter = new AutoTypeListAttributeConverter<>(RoleTypeList.class);
    }

    @Test
    void testConvertToDatabaseColumn() {
        UUID dbData = roleConverter.convertToDatabaseColumn(RoleTypeList.SystemArchitect);
        assertNotNull(dbData);
        assertEquals(RoleTypeList.SystemArchitect.getId(), dbData);
    }

    @Test
    void testConvertToEntityAttribute() {
        UUID id = RoleTypeList.SystemArchitect.getId();
        RoleTypeList role = roleConverter.convertToEntityAttribute(id);
        assertNotNull(role);
        assertEquals(RoleTypeList.SystemArchitect, role);
    }

    @Test
    void testConvertNullToDatabaseColumn() {
        assertNull(roleConverter.convertToDatabaseColumn(null));
    }

    @Test
    void testConvertNullToEntityAttribute() {
        assertNull(roleConverter.convertToEntityAttribute(null));
    }

    @Test
    void testGetConverterForField() throws NoSuchFieldException {
        Field field = User.class.getDeclaredField("role");
        AutoTypeListAttributeConverter<?> converter = (AutoTypeListAttributeConverter<?>)
                AutoTypeListAttributeConverter.getConverterForField(field);

        assertNotNull(converter);
        assertEquals(RoleTypeList.class, converter.getEnumClass());
    }

    @Test
    void testInvalidFieldForConverter() throws NoSuchFieldException {
        Field field = User.class.getDeclaredField("password"); // Non-enum field

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AutoTypeListAttributeConverter.getConverterForField(field);
        });

        String expectedMessage = "AutoTypeListConverter can only be used with TypeList enums.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
