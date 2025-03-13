package com.bazarbozorg.enums;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EnumCache {
    private static final Map<Class<?>, Map<UUID, Enum<?>>> ID_LOOKUP = new ConcurrentHashMap<>();
    private static final Map<Class<?>, Map<String, Enum<?>>> CODE_LOOKUP = new ConcurrentHashMap<>();

    public static <T extends Enum<T> & TypeList<T>> void register(Class<T> enumClass) {
        ID_LOOKUP.computeIfAbsent(enumClass, k -> new ConcurrentHashMap<>());
        CODE_LOOKUP.computeIfAbsent(enumClass, k -> new ConcurrentHashMap<>());

        for (T e : enumClass.getEnumConstants()) {
            Map<UUID, Enum<?>> idMap = ID_LOOKUP.get(enumClass);
            Map<String, Enum<?>> codeMap = CODE_LOOKUP.get(enumClass);

            // 🚨 Check for duplicate ID
            if (idMap.containsKey(e.getId())) {
                throw new IllegalStateException("Duplicate ID detected: " + e.getId() + " in enum " + enumClass.getSimpleName());
            }

            // 🚨 Check for duplicate Code
            if (codeMap.containsKey(e.getCode())) {
                throw new IllegalStateException("Duplicate Code detected: " + e.getCode() + " in enum " + enumClass.getSimpleName());
            }

            // ✅ Store in lookup maps
            idMap.put(e.getId(), e);
            codeMap.put(e.getCode(), e);
        }
    }

    public static <T extends Enum<T> & TypeList<T>> T fromId(Class<T> enumClass, UUID id) {
        return enumClass.cast(ID_LOOKUP.getOrDefault(enumClass, Map.of()).get(id));
    }

    public static <T extends Enum<T> & TypeList<T>> T fromCode(Class<T> enumClass, String code) {
        return enumClass.cast(CODE_LOOKUP.getOrDefault(enumClass, Map.of()).get(code));
    }
}
