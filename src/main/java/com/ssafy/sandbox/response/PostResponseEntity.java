package com.ssafy.sandbox.response;

import lombok.*;

@Getter
@Setter
@ToString
public class PostResponseEntity {
    private int id;
    private boolean completed;

    public PostResponseEntity(int id, boolean completed){
        this.id = id;
        this.completed = completed;
    }
}
