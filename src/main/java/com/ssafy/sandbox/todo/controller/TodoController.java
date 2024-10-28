package com.ssafy.sandbox.todo.controller;

import com.ssafy.sandbox.response.GetResponseEntity;
import com.ssafy.sandbox.response.PostResponseEntity;
import com.ssafy.sandbox.todo.domain.TodoVo;
import com.ssafy.sandbox.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TodoController {
    @Autowired
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    GetResponseEntity selectALl(){
        return new GetResponseEntity(service.findAll());
    }

    @PostMapping("/todos")
    public PostResponseEntity save( @RequestBody String content){
        TodoVo todo = service.save(new TodoVo(content));
        return new PostResponseEntity(todo.getId(), todo.isCompleted());
    }
}
