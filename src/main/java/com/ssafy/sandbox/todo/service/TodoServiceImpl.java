package com.ssafy.sandbox.todo.service;

import com.ssafy.sandbox.todo.domain.TodoVo;
import com.ssafy.sandbox.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TodoVo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TodoVo> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public TodoVo save(TodoVo todo) {
        return repository.save(todo);
    }

    @Override
    public boolean deleteById(int id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public TodoVo updateTodo(int id, TodoVo updatedTodo) {
         if(repository.existsById(id)){
             repository.save(updatedTodo);
         } else{
             throw new IllegalArgumentException("todo not found");
         }
        return repository.findById(id).get();
    }
}
