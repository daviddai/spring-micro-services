package com.kanban.service.api.model.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    private boolean succeed;

    @JsonCreator
    public Response(@JsonProperty("succeed") boolean succeed) {
        this.succeed = succeed;
    }

    public boolean isSucceed() {
        return succeed;
    }
}
