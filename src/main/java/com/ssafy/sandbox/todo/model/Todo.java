package com.ssafy.sandbox.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id = null;
	@Column(name = "content", nullable = false)
	String content;
	@Column(name = "completed", nullable = false)
	Boolean completed = Boolean.FALSE;

	public Todo() {
	}

	private Todo(String content) {
		this.content = content;
	}

	public void toggleCompleted() {
		this.completed = !this.completed;
	}

	public static Todo of(String content) {
		return new Todo(content);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
