package com.kc.sba.code;

public enum StatusCode {
    EMPLOYED("고용"),
    RETIRED("퇴직");

    private final String description;

    private StatusCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
