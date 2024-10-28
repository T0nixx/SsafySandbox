package com.ssafy.sandbox.todo.service;

import java.util.List;

import com.ssafy.sandbox.todo.dto.CreateTodoRequest;
import com.ssafy.sandbox.todo.model.Todo;

public interface TodoService {
	List<Todo> getTodos();

	boolean createTodo(CreateTodoRequest createTodoRequest);

	boolean updateStatus(Integer todoId);

	boolean deleteTodo(Integer todoId);
}
