package roadbook.controller;

import java.util.Collection;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import roadbook.model.Article;
import roadbook.model.Utilisateur;
import roadbook.repository.ArticleRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping("/addArticle")
    public Article ajoutArticle(@RequestBody Article article){
        return articleRepository.saveAndFlush(article);
    }

	@DeleteMapping("/delArticle/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (optArticle.isPresent()) {
            articleRepository.deleteById(id);
            System.out.println("Article supprimé");
        } else {
            System.out.println("Pas d'article avec cet ID");
        }
    }
	
	@GetMapping("/incrementViews/{id}")
	public ResponseEntity<Void> incrementViews(@PathVariable int id) {
		Optional<Article> optArticle = articleRepository.findById(id);
        if (optArticle.isPresent()) {
        	Article articleInBase = optArticle.get();
        	articleInBase.setNb_vue(articleInBase.getNb_vue()+1);
        	articleRepository.saveAndFlush(articleInBase);
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
	}

}

