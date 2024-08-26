package guru.springframework.spring6webclient.client;

import guru.springframework.spring6webclient.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
@Slf4j
class BeerClientImplTest {

    @Autowired
    BeerClient client;

    @Test
    void testUpdate() {

        final String NAME = "New Name";

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeerDtos()
                .next()
                .doOnNext(beerDTO -> beerDTO.setBeerName(NAME))
                .flatMap(dto -> client.updateBeer(dto))
                .subscribe(byIdDto -> {
                    log.info(byIdDto.toString());
                    atomicBoolean.set(true);
                });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testCreateBeer() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle("IPA")
                .quantityOnHand(500)
                .upc("123245")
                .build();

        client.createBeer(newDto)
                .subscribe(dto -> {
                    log.info(dto.toString());
                    atomicBoolean.set(true);
                });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeerByBeerStyle() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.getBeerByBeerStyle("Pale Ale")
                .subscribe(dto -> {
                    log.info(dto.toString());
                    atomicBoolean.set(true);
                });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeerById() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeerDtos()
                .flatMap(dto -> client.getBeerById(dto.getId()))
                .subscribe(byIdDto -> {
                    log.info(byIdDto.getBeerName());
                    atomicBoolean.set(true);
                });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testBeerDto() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeerDtos().subscribe(dto -> {
            log.info(dto.getBeerName());

            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testBeerJson() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeersJsonNode().subscribe(jsonNode -> {
            log.info(jsonNode.toPrettyString());

            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void testListBeerMap() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeerMap().subscribe(response -> {
            log.info(response.toString());
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    void listBeer() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        client.listBeer().subscribe(response -> {
            log.info(response);
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

}