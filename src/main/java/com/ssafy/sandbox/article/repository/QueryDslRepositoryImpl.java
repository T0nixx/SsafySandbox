package com.ssafy.sandbox.article.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
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
	public List<Article> getArticlePageByOffset(Long pageSize, Long offset) {
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
	public List<Article> getArticlePageByCursor(Long pageSize, Long cursorId) {
		BooleanExpression condition = createCursorPaginationCondition(cursorId);

		return jpaQueryFactory.selectFrom(article)
			.where(condition)
			.orderBy(article.createdAt.desc(), article.id.desc())
			.limit(pageSize)
			.fetch();
	}

	private BooleanExpression createCursorPaginationCondition(Long cursorId) {
		if (cursorId == null) {
			return null;
		}

		Article cursorArticle = jpaQueryFactory.selectFrom(article)
			.where(article.id.eq(cursorId))
			.fetchOne();

		if (cursorArticle == null) {
			return null;
		}

		return article.createdAt.lt(cursorArticle.getCreatedAt())
			.or(article.createdAt.eq(cursorArticle.getCreatedAt())
				.and(article.id.lt(cursorId)));
	}
}
