package guru.springframework.spring6webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - raulp
 * @version 25/08/2024 - 15:06
 * @since jdk 1.21
 */
@Service
public class BeerClientImpl implements BeerClient {

    public static final String BEER_PATH = "/api/v3/beer";

    private final WebClient webClient;

    public BeerClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @Override
    public Flux<Map> listBeerMap() {
        return webClient.get().uri(BEER_PATH, Map.class)
                .retrieve().bodyToFlux(Map.class);
    }

    @Override
    public Flux<JsonNode> listBeersJsonNode() {
        return webClient.get().uri(BEER_PATH, JsonNode.class)
                .retrieve().bodyToFlux(JsonNode.class);
    }

    @Override
    public Flux<String> listBeer() {
        return webClient.get().uri(BEER_PATH, String.class)
                .retrieve().bodyToFlux(String.class);
    }

}
