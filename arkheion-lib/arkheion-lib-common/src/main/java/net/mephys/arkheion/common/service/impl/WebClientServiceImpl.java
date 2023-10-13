package net.mephys.arkheion.common.service.impl;

import net.mephys.arkheion.common.service.WebClientService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WebClientServiceImpl implements WebClientService {

    private final WebClient webClient;

    public WebClientServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/project")
                .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE,
                        "Content-Type", MediaType.APPLICATION_JSON_VALUE
                ).build();
    }

    @Override
    public WebClient client() {
        return webClient;
    }

    public <T> List<T> get(String uri, Class<T> type) {
        List<T> list = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<T>>() {})
                .block();
        return list;
    }

}
