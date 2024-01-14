package ma.fstt.market_place_api.repositories;

import ma.fstt.market_place_api.entites.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {

//    @Query("SELECT a FROM Article a WHERE a.store.id = ?1")
//    List<Article> findArticlesByStoreId(Long id);



    List<Article> findArticlesByStoreId(Long store_id);

    List<Article> findArticlesByCategorieId(Long categorie_id);

}
