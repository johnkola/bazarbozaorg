package com.bazarbozorg.core;


import com.bazarbozorg.model.types.LocalTypeList;
import com.bazarbozorg.model.types.RoleTypeList;
import com.bazarbozorg.model.types.TypeList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TypeListEnumUtilTest {

    private static final UUID VALID_UUID_LOCAL = UUID.fromString("3349eb05-d98e-46be-a0b6-a8cd545b46c5");
    private static final UUID VALID_UUID_ROLE = UUID.fromString("7641965e-ae83-4c1f-b126-a21a908bfa22");
    private static final UUID INVALID_UUID = UUID.fromString("7643335e-ae83-4c1f-b126-a21a908bfa22");

    @BeforeAll
    static void setup() {
        TypeList.register(LocalTypeList.class);
        TypeList.register(RoleTypeList.class);
    }

    @Test
    void testRegisterAndLookupById_LocalTypeList() {
        LocalTypeList locale = TypeList.fromId(LocalTypeList.class, VALID_UUID_LOCAL);
        assertNotNull(locale);
        assertEquals(LocalTypeList.EN_CA, locale);
    }

    @Test
    void testRegisterAndLookupByCode_LocalTypeList() {
        LocalTypeList locale = TypeList.fromCode(LocalTypeList.class, "en_CA");
        assertNotNull(locale);
        assertEquals(LocalTypeList.EN_CA, locale);
    }

    @Test
    void testRegisterAndLookupById_RoleTypeList() {
        RoleTypeList role = TypeList.fromId(RoleTypeList.class, VALID_UUID_ROLE);
        assertNotNull(role);
        assertEquals(RoleTypeList.SYSTEM_ARCHITECT, role);
    }

    @Test
    void testRegisterAndLookupByCode_RoleTypeList() {
        RoleTypeList role = TypeList.fromCode(RoleTypeList.class, "System Architect");
        assertNotNull(role);
        assertEquals(RoleTypeList.SYSTEM_ARCHITECT, role);
    }

    @Test
    void testLookupInvalidId() {
        assertNull(TypeList.fromId(LocalTypeList.class, INVALID_UUID));
        assertNull(TypeList.fromId(RoleTypeList.class, INVALID_UUID));
    }

    @Test
    void testLookupInvalidCode() {
        assertNull(TypeList.fromCode(LocalTypeList.class, "invalid_code"));
        assertNull(TypeList.fromCode(RoleTypeList.class, "invalid_code"));
    }


}
