package org.motometer.api.lookup.rest.service;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import org.motometer.api.lookup.rest.api.ImmutableMotometerApi;
import org.motometer.api.lookup.rest.api.MotometerApi;
import org.motometer.api.lookup.rest.api.MotometerApiVersion;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ConstMotometerApiService implements MotometerApiService {

    private final Multimap<String, MotometerApi> envMap = ImmutableListMultimap.of("prod", ImmutableMotometerApi.of(1L, "https://lookup.motometer.org", MotometerApiVersion.VERSION_1));

    @Override
    public Flux<MotometerApi> services(String env) {
        return Flux.fromIterable(envMap.get(env));
    }
}
