package ma.fstt.market_place_api.controllers;


import ma.fstt.market_place_api.entites.Categorie;
import ma.fstt.market_place_api.services.CategorieService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostAuthorize("hasAuthority('ROLE_FOURNISSEUR')")
    @PostMapping
    public void saveCategorie(@RequestBody Categorie c){
        categorieService.saveCategorie(c);
    }

    @GetMapping
    public List<Categorie> findAllCategories(){
        return categorieService.findAllCategories();
    }

    @PostAuthorize("hasAuthority('ROLE_FOURNISSEUR')")
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id){
        categorieService.deleteCategorieById(id);
    }
}
