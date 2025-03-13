package com.bazarbozorg.core;

import com.bazarbozorg.enums.EnumCache;
import com.bazarbozorg.enums.LocalTypeList;
import com.bazarbozorg.enums.RoleTypeList;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EnumCacheTest {

    private static final UUID VALID_UUID_LOCAL = LocalTypeList.EnCa.getId();
    private static final UUID VALID_UUID_ROLE = RoleTypeList.SystemArchitect.getId();

    @Test
    void testLookupById_LocalTypeList() {
        LocalTypeList locale = EnumCache.fromId(LocalTypeList.class, VALID_UUID_LOCAL);
        assertNotNull(locale);
        assertEquals(LocalTypeList.EnCa, locale);
    }

    @Test
    void testLookupByCode_LocalTypeList() {
        LocalTypeList locale = EnumCache.fromCode(LocalTypeList.class, "en_CA");
        assertNotNull(locale);
        assertEquals(LocalTypeList.EnCa, locale);
    }

    @Test
    void testLookupById_RoleTypeList() {
        RoleTypeList role = EnumCache.fromId(RoleTypeList.class, VALID_UUID_ROLE);
        assertNotNull(role);
        assertEquals(RoleTypeList.SystemArchitect, role);
    }

    @Test
    void testLookupByCode_RoleTypeList() {
        RoleTypeList role = EnumCache.fromCode(RoleTypeList.class, "System Architect");
        assertNotNull(role);
        assertEquals(RoleTypeList.SystemArchitect, role);
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
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            EnumCache.register(LocalTypeList.class);
        });

        String expectedMessage = "Duplicate ID detected";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
