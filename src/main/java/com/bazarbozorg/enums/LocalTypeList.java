package com.bazarbozorg.enums;


import java.util.UUID;


public enum LocalTypeList implements TypeList<LocalTypeList> {
    EnCa("en_CA", UUID.fromString("3349eb05-d98e-46be-a0b6-a8cd545b46c5")),
    FrCa("fr_CA", UUID.fromString("872b181d-d0ce-48a2-8730-4961867d9e2c")),
    EsMx("es_MX", UUID.fromString("2ea4440c-8280-4c9d-b342-36412879940c")),
    PtBr("pt_BR", UUID.fromString("b76c1ba3-b3a5-4a44-8631-21a1a2cefaba"));

    static {
        TypeList.register(LocalTypeList.class);
    }

    private final String code;
    private final UUID id;

    LocalTypeList(String code, UUID id) {
        this.code = code;
        this.id = id;
    }

    public static LocalTypeList fromId(UUID id) {
        return TypeList.fromId(LocalTypeList.class, id);
    }

    public static LocalTypeList fromCode(String code) {
        return TypeList.fromCode(LocalTypeList.class, code);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.toStringGeneric();
    }
}
