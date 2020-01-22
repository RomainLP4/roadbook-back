package roadbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import roadbook.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
