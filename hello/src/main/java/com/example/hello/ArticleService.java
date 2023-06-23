package com.example.hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @création 17/06/2023
 * @projet hello
 * @auteur tsyta.diallo
 * @package com.example.hello
 */

@Service
public class ArticleService {

    List<Article> articles= new ArrayList<>();

    public ArticleService() {
        articles.add(new  Article("Article 1", "Desc 1"));
                articles.add(new  Article("Article 2", "Desc 2"));
                articles.add(new  Article("Article 3", "Desc 3"));
                articles.add(new  Article("Article 4", "Desc 4"));
                articles.add(new  Article("Article 5", "Desc 5"));
                articles.add(new  Article("Article 6", "Desc 6"));
                articles.add(new  Article("Article 7", "Desc 7"));
                articles.add(new  Article("Article 8", "Desc 8"));
                articles.add(new  Article("Article 9", "Desc 9"));
                articles.add(new  Article("Article 10", "Desc 10"));
    }

    public List<Article> getArticles(){
        return articles;
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public Article getByLibelle(String libelle){
        return articles.stream().filter(article -> article.getLibelle().equals(libelle)).findFirst().orElseThrow(() -> new IllegalArgumentException("Article non trouvé"));
    }
}
