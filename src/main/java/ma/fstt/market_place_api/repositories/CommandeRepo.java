package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande, Long> {

    List<Commande> findAllByClient_Id(Long client_id);

}
