package guru.springframework.spring6webclient.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
@Slf4j
class BeerClientImplTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void testBeerDto() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        beerClient.listBeerDtos().subscribe(dto -> {
            log.info(dto.getBeerName());

            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testBeerJson() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        beerClient.listBeersJsonNode().subscribe(jsonNode -> {
            log.info(jsonNode.toPrettyString());

            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testListBeerMap() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        beerClient.listBeerMap().subscribe(response -> {
            log.info(response.toString());
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void listBeer() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        beerClient.listBeer().subscribe(response -> {
            log.info(response);
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

}