package com.ssafy.sandbox.response;

public class FetchResponseEntity {
    private String message;

    public FetchResponseEntity(int id) {
        if( id == -1){
            this.message = "정상적이지 않은 요청입니다.";
        } else{
            this.message = id + "의 completed가 정상적으로 토글되었습니다.";
        }
    }
}
