package com.ssafy.sandbox.response;


import com.ssafy.sandbox.todo.domain.TodoVo;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GetResponseEntity {
    private List<TodoVo> todos;
}
