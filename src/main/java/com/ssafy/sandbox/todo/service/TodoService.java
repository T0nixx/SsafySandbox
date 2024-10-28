package com.ssafy.sandbox.todo.service;

import com.ssafy.sandbox.todo.domain.TodoVo;
import com.ssafy.sandbox.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TodoService {
    public List<TodoVo> findAll();
    public Optional<TodoVo> findById(int id);
    public TodoVo save(TodoVo todo);
    public boolean deleteById(int id);
    public TodoVo updateTodo(int id, TodoVo updatedTodo);
}
