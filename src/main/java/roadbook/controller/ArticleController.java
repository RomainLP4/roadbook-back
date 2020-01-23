package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//	@GetMapping("/utilisateurByPseudo/{pseudo}")
//	public Optional<Utilisateur> findByPseudo(@PathVariable String pseudo) {
//		return utilisateurRepository.findByPseudo(pseudo);
//	}
}
