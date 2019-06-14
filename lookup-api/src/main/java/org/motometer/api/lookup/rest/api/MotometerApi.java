package org.motometer.api.lookup.rest.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Value.Immutable
@JsonSerialize
public interface MotometerApi {

    @Value.Parameter
    Long id();

    @Value.Parameter
    String url();

    @Value.Parameter
    MotometerApiVersion version();

    @Nullable
    Boolean deprecated();

    @Nullable
    LocalDate unsupportedSince();
}
