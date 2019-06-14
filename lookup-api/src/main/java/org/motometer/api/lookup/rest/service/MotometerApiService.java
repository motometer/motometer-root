package org.motometer.api.lookup.rest.service;

import org.motometer.api.lookup.rest.api.MotometerApi;
import reactor.core.publisher.Flux;

public interface MotometerApiService {
    Flux<MotometerApi> services(String env);
}
