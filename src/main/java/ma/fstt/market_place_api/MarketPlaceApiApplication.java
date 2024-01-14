package ma.fstt.market_place_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class MarketPlaceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketPlaceApiApplication.class, args);
    }
}
