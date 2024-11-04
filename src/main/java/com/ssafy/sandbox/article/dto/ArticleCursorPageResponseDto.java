package com.ssafy.sandbox.article.dto;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

import lombok.Getter;

@Getter
public class ArticleCursorPageResponseDto {
	List<ArticleResponseDto> articles;
	Long lastId;

	private ArticleCursorPageResponseDto(List<ArticleResponseDto> articles, Long lastId) {
		this.articles = articles;
		this.lastId = lastId;
	}

	public static ArticleCursorPageResponseDto from(List<Article> articles, Long lastId) {
		return new ArticleCursorPageResponseDto(articles.stream().map(ArticleResponseDto::from).toList(),
			lastId);
	}
}
