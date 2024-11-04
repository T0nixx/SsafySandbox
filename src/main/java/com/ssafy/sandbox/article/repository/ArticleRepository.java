package com.ssafy.sandbox.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.sandbox.article.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>, QueryDslRepository {
}
