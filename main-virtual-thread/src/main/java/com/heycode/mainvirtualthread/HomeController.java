package com.heycode.mainvirtualthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class HomeController {
    private final RestClient restClient;
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);


    public HomeController(RestClient.Builder restClient) {
        this.restClient = restClient.baseUrl("http://localhost:8085").build();
    }

    @GetMapping("/block/{seconds}")
    public String home(@PathVariable Integer seconds) {
        ResponseEntity<Void> response = restClient.get()
                .uri("/block/" + seconds)
                .retrieve()
                .toBodilessEntity();

        log.info("{} and {}", response.getStatusCode(), Thread.currentThread());

        return Thread.currentThread().getName();

    }
}
