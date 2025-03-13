package com.bazarbozorg.enums;

import lombok.Getter;

import java.util.UUID;

@Getter
public enum RoleTypeList implements TypeList<RoleTypeList> {
    PolicyAnalyst("Policy Analyst", UUID.fromString("0bc7b4e5-aa01-44d5-a114-8dc46e75c824")),
    SystemArchitect("System Architect", UUID.fromString("7641965e-ae83-4c1f-b126-a21a908bfa22")),
    AutomationEngineer("Automation Engineer", UUID.fromString("ed7f3167-b49e-4e3e-8dcc-f9c4e32f21ce")),
    Actuary("Actuary", UUID.fromString("3473be84-999c-42af-aafa-23b36d3b59e1")),
    CybersecurityAnalyst("Cybersecurity Analyst", UUID.fromString("00000000-0000-0000-0000-000000000000")), // Deprecated placeholder
    DataAnalyst("Data Analyst", UUID.fromString("dab52936-7dfd-43ec-b949-cb6c9f5dc518")),
    IncidentResponder("Incident Responder", UUID.fromString("90b1326d-fa73-4bf1-80f8-fb3a0187f9c8")),
    CloudSolutionsArchitect("Cloud Solutions Architect", UUID.fromString("28b8101c-e6f2-4018-8491-eedbd6e5d440")),
    QaEngineer("QA Engineer", UUID.fromString("a19d32b1-9ed5-4f66-bd7a-9c9f21b9e6ac"));

    static {
        TypeList.register(RoleTypeList.class);
    }

    private final String code;
    private final UUID id;

    RoleTypeList(String code, UUID id) {
        this.code = code;
        this.id = id;
    }

    public static RoleTypeList fromId(UUID id) {
        return TypeList.fromId(RoleTypeList.class, id);
    }

    public static RoleTypeList fromCode(String code) {
        return TypeList.fromCode(RoleTypeList.class, code);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.toStringGeneric();
    }
}
