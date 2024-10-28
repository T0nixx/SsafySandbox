package com.ssafy.sandbox.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeleteResponseEntity {
    private String message;

    public DeleteResponseEntity(int id){
        if(id == -1){
            this.message = "정상적이지 않은 요청입니다.";
        }else{
            this.message = id + "의 todo가 삭제되었습니다.";
        }

    }


}
