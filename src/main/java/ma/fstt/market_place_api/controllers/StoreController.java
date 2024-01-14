package ma.fstt.market_place_api.controllers;


import ma.fstt.market_place_api.entites.Store;
import ma.fstt.market_place_api.entites.dto.SaveStoreDto;
import ma.fstt.market_place_api.services.StoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    @PostMapping
    public void saveStore(@RequestBody SaveStoreDto saveStoreDto){
        storeService.saveStore(saveStoreDto);
    }

    @GetMapping("fournisseur/{id}")
    public Store findStoreByFournisseurId(@PathVariable("id") Long idFrnsr){
        return storeService.findStoreByFournissuerId(idFrnsr);
    }

    @DeleteMapping("{id}")
    public void deleteStore(@PathVariable("id") Long id){
        storeService.deleteStoreById(id);
    }

}
