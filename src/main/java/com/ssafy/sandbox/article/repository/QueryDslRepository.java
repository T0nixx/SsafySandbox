package com.ssafy.sandbox.article.repository;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

public interface QueryDslRepository {
	List<Article> getArticlePageByOffset(Integer pageSize, Integer offset);

	List<Article> getArticlePageByCursor(Integer pageSize, Long cursorId);

	Long getArticleCount();
}
