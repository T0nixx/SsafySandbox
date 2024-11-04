package com.ssafy.sandbox.todo.dto;

import java.util.List;

import com.ssafy.sandbox.todo.model.Todo;

public class GetTodosResponse {
	List<Todo> todos;

	public GetTodosResponse(List<Todo> todos) {
		this.todos = todos;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
}
