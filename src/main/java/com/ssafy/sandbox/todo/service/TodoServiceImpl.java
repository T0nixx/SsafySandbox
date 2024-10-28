package com.ssafy.sandbox.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.todo.dto.CreateTodoRequest;
import com.ssafy.sandbox.todo.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	List<Todo> todos = new ArrayList<>();
	int lastId = 0;

	public TodoServiceImpl() {
		todos.add(Todo.of(lastId++, "운동"));
		todos.add(Todo.of(lastId++, "공부"));
		todos.add(Todo.of(lastId++, "게임"));
	}

	@Override
	public List<Todo> getTodos() {
		return todos;
	}

	@Override
	public boolean createTodo(CreateTodoRequest createTodoRequest) {
		System.out.println(createTodoRequest.getContent());
		if (Math.random() * 10 / 2 > 1) {
			todos.add(Todo.of(lastId++, createTodoRequest.getContent()));
			return true;
		}
		throw new RuntimeException("Intended Exception");
	}

	@Override
	public boolean updateStatus(Integer todoId) {
		return false;
	}

	@Override
	public boolean deleteTodo(Integer todoId) {
		return false;
	}
}
