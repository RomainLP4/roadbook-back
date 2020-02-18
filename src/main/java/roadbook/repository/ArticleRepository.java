package roadbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import roadbook.model.Article;
import roadbook.model.Moto;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	List<Article> findAllByTagContainingIgnoreCase(String tag);
	List<Article> findAllByTagAndAndAuteurAndDescriptionAndTexteAndTitreContainingIgnoreCase(String tag,String titre,String auteur,String description,String texte);
	//List<Article> findAllContainingIgnoreCase(String txt);
	Article saveAndFlush(Article article);
}
