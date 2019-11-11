package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets attestation
 */
public enum Attestation {
    NONE("none"),
    INDIRECT("indirect"),
    DIRECT("direct");

    private String value;

    Attestation(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Attestation fromValue(String text) {
        for (Attestation b : Attestation.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
