package com.ssafy.sandbox.article.dto;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;
import com.ssafy.sandbox.common.util.PaginationUtil;

import lombok.Getter;

@Getter
public class ArticleOffsetPageResponseDto {
	List<ArticleResponseDto> articles;
	Long totalPage;

	private ArticleOffsetPageResponseDto(List<ArticleResponseDto> articles, Long totalPage) {
		this.articles = articles;
		this.totalPage = totalPage;
	}

	public static ArticleOffsetPageResponseDto from(List<Article> articles, Long totalArticleCount, Long pageSize) {
		Long totalPage = PaginationUtil.calculateTotalPage(totalArticleCount, pageSize);
		return new ArticleOffsetPageResponseDto(articles.stream().map(ArticleResponseDto::from).toList(), totalPage
		);
	}
}
