package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {


}
