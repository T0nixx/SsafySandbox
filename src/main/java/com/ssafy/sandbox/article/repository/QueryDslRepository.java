package com.ssafy.sandbox.article.repository;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

public interface QueryDslRepository {
	List<Article> getArticlePageByOffset(Long pageSize, Long offset);

	List<Article> getArticlePageByCursor(Long pageSize, Long cursorId);

	Long getArticleCount();
}
