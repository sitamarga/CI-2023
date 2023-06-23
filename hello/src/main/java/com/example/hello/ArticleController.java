package com.example.hello;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @création 17/06/2023
 * @projet hello
 * @auteur tsyta.diallo
 * @package com.example.hello
 */

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/add")
    public void addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }
    @GetMapping("/get-all")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }
    @GetMapping("/get-one/{libelle}")
    public Article getArticle(@PathVariable("libelle") String libelle){
        return articleService.getByLibelle(libelle);
    }
}
