package ma.fstt.market_place_api.entites.dto;

import lombok.Data;
import ma.fstt.market_place_api.entites.Store;

@Data
public class SaveStoreDto {

    private String nom;
    private Long idFrnsr;


    public Store toStore(){
        return new Store(0L, nom, null, null);
    }
}
