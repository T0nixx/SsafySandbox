package com.ssafy.sandbox.todo.service;

import java.util.List;

import com.ssafy.sandbox.todo.dto.CreateTodoRequest;
import com.ssafy.sandbox.todo.model.Todo;

public interface TodoService {
	List<Todo> getTodos();

	Long createTodo(CreateTodoRequest createTodoRequest);

	void toggleStatus(Long todoId) throws Exception;

	void deleteTodo(Long todoId) throws  Exception;
}
