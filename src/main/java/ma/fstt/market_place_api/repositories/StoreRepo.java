package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepo extends JpaRepository<Store, Long> {

    Store findStoreByFournisseur_Id(Long fournisseur_id);

    @Query("select s FROM Store s WHERE s.fournisseur.id = ?1")
    Store findStoreByFrnsrId(Long id);
}
