package com.ssafy.sandbox.todo.repository;

import com.ssafy.sandbox.todo.domain.TodoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoVo, Integer> {
}