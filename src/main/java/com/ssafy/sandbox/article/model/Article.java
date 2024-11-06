package com.ssafy.sandbox.article.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@Getter
@NoArgsConstructor
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;

	@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP(6)")
	private Instant createdAt;

	@Column(name = "title", nullable = false)
	private String title;

	private Article(String title) {
		this.title = title;
		this.createdAt = Instant.now();
		System.out.println(createdAt);
	}

	public static Article of(String title) {
		return new Article(title);
	}
}
