package com.cognizant.sharecar.service;

class GetAllQuery {
    private TaskStatus status;

    GetAllQuery(TaskStatus status) {
        this.status = status;
    }

    GetAllQuery() { }

    TaskStatus getStatus() {
        return status;
    }
}
