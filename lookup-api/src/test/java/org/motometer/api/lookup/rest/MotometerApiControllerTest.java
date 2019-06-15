package org.motometer.api.lookup.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class MotometerApiControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void apis() {
        webClient.get().uri("/services").exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("[{\"id\":1,\"url\":\"https://lookup.motometer.org\",\"version\":\"1.0\"}]");

    }
}