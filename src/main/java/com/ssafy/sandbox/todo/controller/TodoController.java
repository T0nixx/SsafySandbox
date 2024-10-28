package com.ssafy.sandbox.todo.controller;

import com.ssafy.sandbox.response.DeleteResponseEntity;
import com.ssafy.sandbox.response.FetchResponseEntity;
import com.ssafy.sandbox.response.GetResponseEntity;
import com.ssafy.sandbox.response.PostResponseEntity;
import com.ssafy.sandbox.todo.domain.TodoVo;
import com.ssafy.sandbox.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*", "*/*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS})
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
    public PostResponseEntity save( @RequestBody TodoVo todoVo){
        TodoVo todo = service.save(todoVo);
        return new PostResponseEntity(todo.getId(), todo.isCompleted());
    }

    @DeleteMapping("/todos/{todoId}")
    public DeleteResponseEntity delete(@PathVariable int todoId){
        int resultId = service.deleteById(todoId) ? todoId : -1;
        return new DeleteResponseEntity(resultId);
    }

    @PatchMapping("/todos/{todoId}")
    public FetchResponseEntity fetch(@PathVariable int todoId){
        int resultId = service.updateTodo(todoId) != null ? todoId : -1;
        return new FetchResponseEntity(resultId);
    }



}
