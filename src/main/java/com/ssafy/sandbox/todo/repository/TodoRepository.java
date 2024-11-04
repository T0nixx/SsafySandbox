package com.ssafy.sandbox.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.sandbox.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
