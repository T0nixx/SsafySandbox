package com.ssafy.sandbox.article.dto;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.ssafy.sandbox.article.model.Article;

import lombok.Getter;

@Getter
public class ArticleResponseDto {
	private final Long id;
	private final String title;
	private final String createdAt;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'XXX",
			Locale.ENGLISH)
		.withZone(ZoneId.of("Asia/Seoul"));

	private ArticleResponseDto(Long id, String title, String createdAt) {
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
	}

	public static ArticleResponseDto from(Article article) {
		return new ArticleResponseDto(article.getId(), article.getTitle(), formatInstant(article.getCreatedAt()));
	}

	private static String formatInstant(Instant instant) {
		return formatter.format(instant);
	}

}
