/*
 *
 *  Copyright (c) 2025 Bazarbozorg Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information
 *  of Bazarbozorg Inc. ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement
 *  you entered into with Bazarbozorg Inc.
 *
 */

package com.bazarbozorg.model.types;

import java.util.UUID;

public interface TypeList<T extends Enum<T> & TypeList<T>> {

    static <T extends Enum<T> & TypeList<T>> T fromId(Class<T> enumClass, UUID id) {
        return EnumCache.fromId(enumClass, id);
    }

    static <T extends Enum<T> & TypeList<T>> T fromCode(Class<T> enumClass, String code) {
        return EnumCache.fromCode(enumClass, code);
    }

    static <T extends Enum<T> & TypeList<T>> void register(Class<T> enumClass) {
        EnumCache.register(enumClass);
    }

    UUID getId();

    String getCode();

    default String toStringGeneric() {
        return String.format("{\"code\":\"%s\", \"id\":\"%s\"}", getCode(), getId());
    }

}
