package net.mephys.arkheion.common.service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public interface WebClientService {
     WebClient client();
     <T> List<T> get(String uri, Class<T> type);

}
