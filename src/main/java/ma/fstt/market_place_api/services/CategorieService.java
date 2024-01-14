package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Categorie;
import ma.fstt.market_place_api.repositories.CategorieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepo categorieRepo;

    public CategorieService(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }

    public List<Categorie> findAllCategories(){
        return categorieRepo.findAll();
    }

    public void saveCategorie(Categorie categorie){
        categorieRepo.save(categorie);
    }

    public void deleteCategorieById(Long id){
        categorieRepo.deleteById(id);
    }

}
