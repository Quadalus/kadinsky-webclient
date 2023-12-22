package ru.bikkul.kadinsky.webclient.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bikkul.kadinsky.webclient.client.KadinskyClient;

public class KadinskyClientImpl implements KadinskyClient {
    public static final int BUFFER_SIZE = 10485760;
    private final WebClient webClient;


    public KadinskyClientImpl(@Value("${kadinsky.api.key}") String key,
                              @Value("${kadinsky.api.secret}") String secret,
                              @Value("${kadinsky.api.endpoint.url}") String url) {
        this.webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("X-Key", key)
                .defaultHeader("X-Secret", secret)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(codec -> codec.defaultCodecs().maxInMemorySize(BUFFER_SIZE)).build())
                .build();
    }

    @Override
    public String generatePicture() {
        return null;
    }

    @Override
    public String checkServiceAvailable() {
        return null;
    }

    @Override
    public String checkGenerateStatus(String uuid) {
        return null;
    }
}
