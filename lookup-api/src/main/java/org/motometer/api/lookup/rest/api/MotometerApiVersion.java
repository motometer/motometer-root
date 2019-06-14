package org.motometer.api.lookup.rest.api;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MotometerApiVersion {

    VERSION_1("1.0");

    @JsonValue
    private final String value;
}
