package com.ssafy.sandbox.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sandbox.todo.dto.CreateTodoRequest;
import com.ssafy.sandbox.todo.dto.GetTodosResponse;
import com.ssafy.sandbox.todo.model.Todo;
import com.ssafy.sandbox.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public ResponseEntity<GetTodosResponse> getTodos() {
		List<Todo> todos = todoService.getTodos();
		return ResponseEntity.ok(new GetTodosResponse(todos));
	}


	@PostMapping
	public ResponseEntity<Void> createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
		todoService.createTodo(createTodoRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PatchMapping("/{todoId}")
	public ResponseEntity<Void> toggleStatus(@PathVariable Long todoId) throws Exception {
		todoService.toggleStatus(todoId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) throws Exception {
		todoService.deleteTodo(todoId);
		return ResponseEntity.noContent().build();
	}
	
}
