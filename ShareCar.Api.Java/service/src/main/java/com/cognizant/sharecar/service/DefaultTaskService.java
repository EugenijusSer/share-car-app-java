package com.cognizant.sharecar.service;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultTaskService implements TaskService {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll(GetAllQuery getAllQuery) {
        return tasks.stream()
                .filter(task -> task.getStatus() == getAllQuery.getStatus() || getAllQuery.getStatus() == null)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Task task) {
//        int reduce = getUniqueId();
//        task.setId(reduce);
        tasks.add(task);
    }

    @Override
    public void delete(Task task) {
        tasks.remove(task);
    }

    private int getUniqueId() {
        return new Random().ints(5).reduce((a, b) -> a * 10 + b).getAsInt();
    }
}
