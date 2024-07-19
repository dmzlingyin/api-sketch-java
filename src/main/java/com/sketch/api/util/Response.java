package com.sketch.api.util;

import com.fasterxml.jackson.annotation.JsonInclude;

public  class Response {
    private int code;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
