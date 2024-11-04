package com.ssafy.sandbox.article.service;

import java.util.List;

import com.ssafy.sandbox.article.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.article.dto.ArticleOffsetPageResponseDto;
import com.ssafy.sandbox.article.model.Article;

public interface ArticleService {

	ArticleOffsetPageResponseDto getArticlesWithOffset(Integer pageSize, Integer page);

	ArticleCursorPageResponseDto getArticlesWithCursor(Integer pageSize, Long cursorId);

	void makeArticles(List<Article> articles);

}
