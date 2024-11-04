package com.ssafy.sandbox.article.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.sandbox.article.model.Article;
import com.ssafy.sandbox.article.model.QArticle;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslRepositoryImpl implements QueryDslRepository {
	private final JPAQueryFactory jpaQueryFactory;
	private final QArticle article = QArticle.article;

	@Override
	public List<Article> getArticlePageByOffset(Integer pageSize, Integer offset) {
		return jpaQueryFactory.selectFrom(article)
			.orderBy(article.createdAt.desc())
			.offset(offset)
			.limit(pageSize)
			.fetch();
	}

	public Long getArticleCount() {
		return jpaQueryFactory.select(article.count()).from(article).fetchOne();
	}

	@Override
	public List<Article> getArticlePageByCursor(Integer pageSize, Long cursorId) {
		return jpaQueryFactory.selectFrom(article)
			.where(article.createdAt.loe(
					jpaQueryFactory.select(article.createdAt).from(article).where(article.id.eq(cursorId)))
				.and(article.id.ne(cursorId)))
			.orderBy(article.createdAt.desc())
			.limit(pageSize)
			.fetch();
	}
}
