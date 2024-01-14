package ma.fstt.market_place_api.controllers;


import ma.fstt.market_place_api.entites.Article;
import ma.fstt.market_place_api.entites.dto.SaveArticleDto;
import ma.fstt.market_place_api.services.ArticleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PreAuthorize("hasAuthority('ROLE_FOURNISSEUR')")
    @PostMapping
    public void saveArticle(@RequestBody SaveArticleDto saveArticleDto){
        articleService.saveArticle(saveArticleDto);
    }

    @GetMapping
    public List<Article> findAllArticles(){
        return articleService.findAllArticles();
    }

    @GetMapping("categorie/{id}")
    public List<Article> findArticlesByCategorieId(@PathVariable("id") Long id){
        return articleService.findArticlesByCategorieId(id);
    }

    @PreAuthorize("hasAuthority('ROLE_FOURNISSEUR')")
    @DeleteMapping("{id}")
    public void deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticleById(id);
    }

}
