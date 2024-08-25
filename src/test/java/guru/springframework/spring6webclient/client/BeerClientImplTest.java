package guru.springframework.spring6webclient.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BeerClientImplTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void listBeer() throws InterruptedException {
        beerClient.listBeer().subscribe(log::info);

        Thread.sleep(1000L);
    }

}