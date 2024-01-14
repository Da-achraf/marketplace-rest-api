package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {
}
