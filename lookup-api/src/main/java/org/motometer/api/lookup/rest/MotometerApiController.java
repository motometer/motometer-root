package org.motometer.api.lookup.rest;

import lombok.RequiredArgsConstructor;
import org.motometer.api.lookup.rest.api.MotometerApi;
import org.motometer.api.lookup.rest.service.MotometerApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MotometerApiController {

    private final MotometerApiService motometerApiService;

    @GetMapping("/services")
    public Flux<MotometerApi> apis() {
        return motometerApiService.services("prod");
    }

    @GetMapping("/services/{env}")
    public Flux<MotometerApi> apis(@PathVariable("env") String env) {
        return motometerApiService.services(env);
    }
}
