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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

	@GetMapping("/paging/offset")
	public ResponseEntity<ArticleOffsetPageResponseDto> getArticlesWithOffset(@RequestParam Integer size,
		@RequestParam Integer page) {
		return ResponseEntity.ok(articleService.getArticlesWithOffset(size, page));
	}

	@GetMapping("/paging/cursor")
	public ResponseEntity<ArticleCursorPageResponseDto> getArticlesWithCursor(@RequestParam Integer size,
		@RequestParam Long cursorId) {
		return ResponseEntity.ok(articleService.getArticlesWithCursor(size, cursorId));
	}

	@PostMapping("/make")
	public ResponseEntity<Void> makeArticles(@RequestBody MakeArticlesRequestDto makeArticlesRequestDto) {
		articleService.makeArticles(makeArticlesRequestDto.getArticles());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
