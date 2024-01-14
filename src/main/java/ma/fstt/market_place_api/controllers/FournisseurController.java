package ma.fstt.market_place_api.controllers;


import ma.fstt.market_place_api.entites.Fournisseur;
import ma.fstt.market_place_api.services.FournisseurService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }


    @PostMapping
    public void saveFournisseur(@RequestBody Fournisseur f){
        fournisseurService.saveFournisseur(f);
    }

}
