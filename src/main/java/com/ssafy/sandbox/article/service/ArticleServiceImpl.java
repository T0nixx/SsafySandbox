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
	public ArticleOffsetPageResponseDto getArticlesWithOffset(Integer pageSize, Integer page) {
		List<Article> articles = articleRepository.getArticlePageByOffset(pageSize, page * pageSize);
		Long totalCount = articleRepository.getArticleCount();
		return ArticleOffsetPageResponseDto.from(articles, totalCount);
	}

	@Override
	public ArticleCursorPageResponseDto getArticlesWithCursor(Integer pageSize, Long cursorId) {
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
