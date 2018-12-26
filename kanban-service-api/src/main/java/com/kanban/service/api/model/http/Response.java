package com.kanban.service.api.model.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    private boolean succeed;
    private String message;

    @JsonCreator
    public Response(@JsonProperty("succeed") boolean succeed,
                    @JsonProperty("message") String message) {
        this.succeed = succeed;
        this.message = message;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public String getMessage() {
        return message;
    }
}
