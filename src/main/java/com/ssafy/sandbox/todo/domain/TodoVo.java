package com.ssafy.sandbox.todo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Todos")
public class TodoVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completed;

    public TodoVo(String content){
        this.content = content;
        this.completed = false;
    }
}
