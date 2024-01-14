package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Article;
import ma.fstt.market_place_api.entites.Categorie;
import ma.fstt.market_place_api.entites.Store;
import ma.fstt.market_place_api.entites.dto.SaveArticleDto;
import ma.fstt.market_place_api.repositories.ArticleRepo;
import ma.fstt.market_place_api.repositories.CategorieRepo;
import ma.fstt.market_place_api.repositories.StoreRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepo articleRepo;
    private final CategorieRepo categorieRepo;
    private final StoreRepo storeRepo;

    public ArticleService(ArticleRepo articleRepo, CategorieRepo categorieRepo, StoreRepo storeRepo) {
        this.articleRepo = articleRepo;
        this.categorieRepo = categorieRepo;
        this.storeRepo = storeRepo;
    }

    public List<Article> findAllArticles(){
        return articleRepo.findAll();
    }

    public List<Article> findArticlesByStoreId(Long id){
        return articleRepo.findArticlesByStoreId(id);
    }

    public List<Article> findArticlesByCategorieId(Long id){
        return articleRepo.findArticlesByCategorieId(id);
    }

    @Transactional
    public void saveArticle(SaveArticleDto saveArticleDto){
        Categorie categorie = categorieRepo.findById(saveArticleDto.getIdCategorie()).get();
        Store store = storeRepo.findById(saveArticleDto.getIdStore()).get();
        Article article = saveArticleDto.toArticle();

        article.setStore(store);
        article.setCategorie(categorie);

        articleRepo.save(article);
    }

    public void deleteArticleById(Long id){
        articleRepo.deleteById(id);
    }

}
