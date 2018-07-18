package com.cognizant.sharecar.service;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class TaskServiceTest {

    private TaskService taskService;

    @Before
    public void setUp(){
        taskService = new DefaultTaskService();
    }

    @Test
    public void getAll_NoTasksWereAdded_ReturnEmptyTaskList(){
        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_OneTaskWasAdded_ReturnOneTask(){
        addTask(TaskStatus.DONE);

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(1));
    }


    @Test
    public void getAll_StatusIsDone_ReturnEmpty(){
        addTask(TaskStatus.OPEN);

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(0));
    }


    @Test
    public void getAll_TwoTasksWereAddedAndStatusIsDone_ReturnsOneTask(){
        addTask(TaskStatus.OPEN);
        addTask(TaskStatus.DONE);

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_TwoTasksWereAddedAndStatusIsAbsent_ReturnsTwoTasks(){
        addTask(TaskStatus.DONE);
        addTask(TaskStatus.DONE);

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(2));
    }

    @Test
    public void delete_AddOneTask_OneTaskIsDeleted(){
        addTask(TaskStatus.DONE);
        addTask(TaskStatus.OPEN);
        addTask(TaskStatus.IN_PROGRESS);

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        Task task = tasks.get(0);
        taskService.delete(task);

        List<Task> fetchedTasks = taskService.getAll(new GetAllQuery());

        assertThat(fetchedTasks, hasSize(2));
    }

    private void addTask(TaskStatus taskStatus) {
        Task task = new Task();
        task.setStatus(taskStatus);
        taskService.add(task);
    }
}
