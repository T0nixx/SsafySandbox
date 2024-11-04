package com.ssafy.sandbox.article.dto;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

import lombok.Getter;

@Getter
public class ArticleOffsetPageResponseDto {
	List<ArticleResponseDto> articles;
	Long totalArticleCount;

	private ArticleOffsetPageResponseDto(List<ArticleResponseDto> articles, Long totalArticleCount) {
		this.articles = articles;
		this.totalArticleCount = totalArticleCount;
	}

	public static ArticleOffsetPageResponseDto from(List<Article> articles, Long totalArticleCount) {
		return new ArticleOffsetPageResponseDto(articles.stream().map(ArticleResponseDto::from).toList(),
			totalArticleCount);
	}
}
