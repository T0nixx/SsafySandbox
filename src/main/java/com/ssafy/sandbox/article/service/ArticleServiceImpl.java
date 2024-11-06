package com.ssafy.sandbox.article.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.article.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.article.dto.ArticleOffsetPageResponseDto;
import com.ssafy.sandbox.article.model.Article;
import com.ssafy.sandbox.article.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
	private final ArticleRepository articleRepository;

	@Override
	public ArticleOffsetPageResponseDto getArticlesWithOffset(Long pageSize, Long offset) {
		List<Article> articles = articleRepository.getArticlePageByOffset(pageSize, offset);
		Long totalArticleCount = articleRepository.getArticleCount();

		return ArticleOffsetPageResponseDto.from(articles, totalArticleCount, pageSize);
	}

	@Override
	public ArticleCursorPageResponseDto getArticlesWithCursor(Long pageSize, Long cursorId) {
		List<Article> articles = articleRepository.getArticlePageByCursor(pageSize, cursorId);
		int listSize = articles.size();

		Long lastId = listSize == 0 ? null : articles.get(listSize - 1).getId();
		return ArticleCursorPageResponseDto.from(articles, lastId);
	}

	@Override
	public void makeArticles(List<Article> articles) {
		articleRepository.saveAll(articles);
	}
}
