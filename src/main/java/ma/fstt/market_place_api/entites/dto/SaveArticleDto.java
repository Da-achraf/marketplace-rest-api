package ma.fstt.market_place_api.entites.dto;

import lombok.Data;
import ma.fstt.market_place_api.entites.Article;

@Data
public class SaveArticleDto {

    private String libelle;
    private Float pu;

    private Long idCategorie;
    private Long idStore;

    public Article toArticle(){
        return new Article(
                0L,
                libelle,
                pu,
                null,
                null
        );
    }
}
