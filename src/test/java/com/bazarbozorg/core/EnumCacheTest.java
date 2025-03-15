package com.bazarbozorg.core;


import com.bazarbozorg.model.types.EnumCache;
import com.bazarbozorg.model.types.LocalTypeList;
import com.bazarbozorg.model.types.RoleTypeList;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EnumCacheTest {

    private static final UUID VALID_UUID_LOCAL = LocalTypeList.EN_CA.getId();
    private static final UUID VALID_UUID_ROLE = RoleTypeList.SYSTEM_ARCHITECT.getId();

    @Test
    void testLookupById_LocalTypeList() {
        LocalTypeList locale = EnumCache.fromId(LocalTypeList.class, VALID_UUID_LOCAL);
        assertNotNull(locale);
        assertEquals(LocalTypeList.EN_CA, locale);
    }

    @Test
    void testLookupByCode_LocalTypeList() {
        LocalTypeList locale = EnumCache.fromCode(LocalTypeList.class, "en_CA");
        assertNotNull(locale);
        assertEquals(LocalTypeList.EN_CA, locale);
    }

    @Test
    void testLookupById_RoleTypeList() {
        RoleTypeList role = EnumCache.fromId(RoleTypeList.class, VALID_UUID_ROLE);
        assertNotNull(role);
        assertEquals(RoleTypeList.SYSTEM_ARCHITECT, role);
    }

    @Test
    void testLookupByCode_RoleTypeList() {
        RoleTypeList role = EnumCache.fromCode(RoleTypeList.class, "System Architect");
        assertNotNull(role);
        assertEquals(RoleTypeList.SYSTEM_ARCHITECT, role);
    }

    @Test
    void testDuplicateIdThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            EnumCache.register(LocalTypeList.class);
        });

        String expectedMessage = "Duplicate ID detected";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDuplicateCodeThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> EnumCache.register(LocalTypeList.class));

        String expectedMessage = "Duplicate ID detected";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
