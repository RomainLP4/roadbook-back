package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import roadbook.model.Article;
import roadbook.repository.ArticleRepository;


@CrossOrigin(origins = "http://localhost:4200")
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

	@PostMapping("/addArticle")
	public Article ajoutArticle(@RequestBody Article article){
		return articleRepository.saveAndFlush(article);
	}




}

