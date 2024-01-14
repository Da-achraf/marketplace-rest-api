package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur, Long> {
}
