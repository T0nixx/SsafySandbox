package com.ssafy.sandbox.todo.model;

public class Todo {
	Integer id;
	String content;
	boolean completed;

	public Todo() {
	}

	private Todo(Integer id, String content) {
		this.id = id;
		this.content = content;
	}

	public static Todo of(Integer id, String content) {
		return new Todo(id, content);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
