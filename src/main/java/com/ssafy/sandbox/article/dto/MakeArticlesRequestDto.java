package com.ssafy.sandbox.article.dto;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

import lombok.Data;

@Data
public class MakeArticlesRequestDto {
	List<MakeArticleRequestDto> articles;

	@Data
	public static class MakeArticleRequestDto {
		private String title;
	}

	public List<Article> toArticles() {
		return articles.stream().map(articleRequest -> Article.of(articleRequest.getTitle())).toList();
	}
}
