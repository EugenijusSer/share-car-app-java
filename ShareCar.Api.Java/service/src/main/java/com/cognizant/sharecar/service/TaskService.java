package com.cognizant.sharecar.service;

import java.util.List;

public interface TaskService {
    List<Task> getAll(GetAllQuery getAllQuery);

    void add(Task task);

    void delete(Task task);
}
