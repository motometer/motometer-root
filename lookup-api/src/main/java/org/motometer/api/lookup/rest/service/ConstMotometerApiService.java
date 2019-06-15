package org.motometer.api.lookup.rest.service;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.motometer.api.lookup.rest.api.ImmutableMotometerApi;
import org.motometer.api.lookup.rest.api.MotometerApi;
import org.motometer.api.lookup.rest.api.MotometerApiVersion;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ConstMotometerApiService implements MotometerApiService {

    private final Multimap<String, MotometerApi> envMap = ImmutableListMultimap.of("prod", ImmutableMotometerApi.of(1L, "https://lookup.motometer.org", MotometerApiVersion.VERSION_1));

    @Override
    public Flux<MotometerApi> services(String env) {
        return Mono.just(env)
                .doOnNext(arg -> log.info("Looking for api for env {}", arg))
                .map(envMap::get)
                .flatMapMany(Flux::fromIterable);
    }
}
