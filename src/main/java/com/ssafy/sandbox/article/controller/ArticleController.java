package com.ssafy.sandbox.article.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sandbox.article.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.article.dto.ArticleOffsetPageResponseDto;
import com.ssafy.sandbox.article.dto.MakeArticlesRequestDto;
import com.ssafy.sandbox.article.service.ArticleService;
import com.ssafy.sandbox.common.util.PaginationUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

	@GetMapping("/paging/offset")
	public ResponseEntity<ArticleOffsetPageResponseDto> getArticlesWithOffset(
		@RequestParam(defaultValue = "10") Long size,
		@RequestParam(defaultValue = "1") Long page) {
		Long offset = PaginationUtil.calculateOffset(page, size);
		return ResponseEntity.ok(articleService.getArticlesWithOffset(size, offset));
	}

	@GetMapping("/paging/cursor")
	public ResponseEntity<ArticleCursorPageResponseDto> getArticlesWithCursor(
		@RequestParam(defaultValue = "10") Long size,
		@RequestParam(defaultValue = "0") Long cursorId) {
		return ResponseEntity.ok(articleService.getArticlesWithCursor(size, cursorId));
	}

	@PostMapping("/make")
	public ResponseEntity<Void> makeArticles(@RequestBody MakeArticlesRequestDto articlesRequest) {
		articleService.makeArticles(articlesRequest.toArticles());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
