package com.example.serviceshuffle.service;

import com.example.serviceshuffle.model.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class LogService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    @Value("${service.log.url}")
    private String url;
    @Value("${service.log.endpoint}")
    private String logEndpoint;

    @Async
    public CompletableFuture<String> sendLog(String message) {
        WebClient webClient = webClientBuilder.build();

        return webClient.post()
                .uri(url + logEndpoint)
                .bodyValue(new LogMessage(message))
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();
    }
}
