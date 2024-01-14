package ma.fstt.market_place_api.entites.dto;

import lombok.Data;
import ma.fstt.market_place_api.entites.Commande;

import java.sql.Date;

@Data
public class SaveCommandeDto {

    private Date date;
    private Long idClient;


    public Commande toCommande(){
        return new Commande(0L, date, null, null);
    }
}
