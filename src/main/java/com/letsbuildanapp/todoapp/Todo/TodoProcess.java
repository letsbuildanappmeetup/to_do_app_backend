package com.letsbuildanapp.todoapp.Todo;

import com.datastax.driver.core.utils.UUIDs;
import com.letsbuildanapp.todoapp.data.Todo;
import com.letsbuildanapp.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TodoProcess {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoProcess(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    Todo getOneTodo(String title) {
        Todo todo = todoRepository.findByTitle(title);
        System.out.println(todo);
        return todo;
    }

    List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        Iterable<Todo> toDosRepositoryAll = this.todoRepository.findAll();
        for (Todo todo : toDosRepositoryAll) {
            todos.add(todo);
        }
        System.out.println(todos);
        return todos;
    }

    void createTodo(Todo todo) {
        Todo todo1 = new Todo();
        todo1.setId(UUIDs.timeBased());
        todo1.setDescription(todo.getDescription());
        todo1.setTitle(todo.getTitle());
        todoRepository.save(todo1);
    }

    void deleteTodo(UUID uuid) {
        todoRepository.delete(uuid);
    }

    void updateTodoDesc(UUID uuid, String description) {
        todoRepository.updateTodoDesc(uuid, description);
    }

    void updateTodoTitle(UUID uuid, String title) {
        todoRepository.updateTodoTitle(uuid, title);
    }
}
