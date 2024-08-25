package guru.springframework.spring6webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - raulp
 * @version 25/08/2024 - 15:06
 * @since jdk 1.21
 */
public interface BeerClient {

    Flux<String> listBeer();

    Flux<Map> listBeerMap();

    Flux<JsonNode> listBeersJsonNode();
}
