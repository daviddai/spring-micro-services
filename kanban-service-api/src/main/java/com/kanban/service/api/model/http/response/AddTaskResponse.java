package com.kanban.service.api.model.http.response;

import com.micro.service.common.model.http.Response;

public class AddTaskResponse extends Response {
    private final static String TASK_ID = "taskId";

    public static class Builder {
        private AddTaskResponse addTaskResponse;

        public Builder() {
            this.addTaskResponse = new AddTaskResponse();
        }

        public Builder isSucceed(boolean succeed) {
            this.addTaskResponse.succeed = succeed;
            return this;
        }

        public Builder withMessage(String message) {
            this.addTaskResponse.message = message;
            return this;
        }

        public Builder withTaskId(long taskId) {
            this.addTaskResponse.getData().put(TASK_ID, taskId);
            return this;
        }

        public AddTaskResponse build() {
            return addTaskResponse;
        }
    }
}
