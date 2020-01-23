package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Article;
import roadbook.model.Utilisateur;
import roadbook.repository.ArticleRepository;

@RestController
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles")
	public Collection<Article> findAll(){

		return articleRepository.findAll();
	}
	@GetMapping("/articlesByTag/{tag}")
	public Optional<Article> findByTag(@PathVariable String tag) {
		return articleRepository.findByTag(tag);
	}


	@RequestMapping("/delArticle/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (optArticle.isPresent()) {
            articleRepository.deleteById(id);
            System.out.println("Article supprimé");
        } else {
            System.out.println("Pas d'article avec cet ID");
        }
    }


	


}

