package guru.springframework.spring6webclient.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by jt, Spring Framework Guru.
 *
 * @author architecture - raulp
 * @version 26/08/2024 - 08:40
 * @since jdk 1.21
 */
@Builder
@Data
public class BeerDTO {

    private String id;
    private Integer version;
    private String beerName;
    private String beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

}
