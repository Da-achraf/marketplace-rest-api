package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Fournisseur;
import ma.fstt.market_place_api.entites.Store;
import ma.fstt.market_place_api.entites.dto.SaveStoreDto;
import ma.fstt.market_place_api.repositories.FournisseurRepo;
import ma.fstt.market_place_api.repositories.StoreRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepo storeRepo;
    private final FournisseurRepo fournisseurRepo;

    public StoreService(StoreRepo storeRepo, FournisseurRepo fournisseurRepo) {
        this.storeRepo = storeRepo;
        this.fournisseurRepo = fournisseurRepo;
    }

    public Store findStoreById(Long id){
        return storeRepo.findById(id).get();
    }

    public List<Store> findAllStores(){
        return storeRepo.findAll();
    }

    public Store findStoreByFournissuerId(Long id){
        return storeRepo.findStoreByFrnsrId(id);
    }


    @Transactional
    public void saveStore(SaveStoreDto saveStoreDto){
        Fournisseur f = fournisseurRepo.findById(saveStoreDto.getIdFrnsr()).get();
        Store store = saveStoreDto.toStore();
        store.setFournisseur(f);
        storeRepo.save(store);
    }

//    @Transactional
//    public void saveStore(Store store, Long idFrnsr){
//        Fournisseur f = fournisseurRepo.findById(idFrnsr).get();
//        store.setFournisseur(f);
//        storeRepo.save(store);
//    }

    public void deleteStoreById(Long id){
        storeRepo.deleteById(id);
    }

}
