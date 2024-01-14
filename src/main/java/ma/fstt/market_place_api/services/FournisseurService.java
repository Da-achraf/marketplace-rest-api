package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Fournisseur;
import ma.fstt.market_place_api.repositories.FournisseurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    private final FournisseurRepo fournisseurRepo;

    public FournisseurService(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

    public List<Fournisseur> findAllFournisseurs(){
        return fournisseurRepo.findAll();
    }

    public void saveFournisseur(Fournisseur fournisseur){
        fournisseurRepo.save(fournisseur);
    }

    public void deleteFournisseurById(Long id){
        fournisseurRepo.deleteById(id);
    }

}
