package com.cognizant.sharecar.service;

class Task {
    private TaskStatus status;
    private int id;

    TaskStatus getStatus() {
        return status;
    }

    void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
