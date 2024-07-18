package com.sketch.api.util;

public class ResponseUtil {

    public static Response response(int code, String message, Object data) {
        return new Response(code, message, data);
    }

}

