package roadbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import roadbook.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	public Optional<Article> findByTag(String tag);
}
