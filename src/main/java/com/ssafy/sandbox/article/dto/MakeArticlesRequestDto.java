package com.ssafy.sandbox.article.dto;

import java.util.List;

import com.ssafy.sandbox.article.model.Article;

import lombok.Data;

@Data
public class MakeArticlesRequestDto {
	List<Article> articles;
}
