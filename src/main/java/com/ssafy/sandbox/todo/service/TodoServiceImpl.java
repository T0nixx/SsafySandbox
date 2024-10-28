package com.ssafy.sandbox.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.todo.dto.CreateTodoRequest;
import com.ssafy.sandbox.todo.model.Todo;
import com.ssafy.sandbox.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoServiceImpl implements TodoService {
	final TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Long createTodo(CreateTodoRequest createTodoRequest) {
		return todoRepository.save(Todo.of(createTodoRequest.getContent())).getId();
	}

	@Transactional
	@Override
	public void toggleStatus(Long todoId) throws Exception {
		todoRepository.findById(todoId).orElseThrow(Exception::new).toggleCompleted();
	}

	@Override
	public void deleteTodo(Long todoId) throws Exception {
		todoRepository.delete(todoRepository.findById(todoId).orElseThrow(Exception::new));
	}
}
