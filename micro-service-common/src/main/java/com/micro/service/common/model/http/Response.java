package com.micro.service.common.model.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Response {
    protected boolean succeed;
    protected String message;
    private Map<String, Object> data;

    @JsonCreator
    public Response() {
        this.data = new HashMap<>();
    }

    @JsonCreator
    public Response(@JsonProperty("succeed") boolean succeed,
                    @JsonProperty("message") String message,
                    @JsonProperty("data") Map<String, Object> data) {
        this.succeed = succeed;
        this.data = data;
    }

    @JsonGetter("succeed")
    public boolean isSucceed() {
        return succeed;
    }

    @JsonGetter("message")
    public String getMessage() {
        return message;
    }

    @JsonGetter("data")
    public Map<String, Object> getData() {
        return data;
    }
}
