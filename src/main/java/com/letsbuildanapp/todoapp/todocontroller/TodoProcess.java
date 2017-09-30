package com.letsbuildanapp.todoapp.todocontroller;

import com.letsbuildanapp.todoapp.model.Todo;
import com.letsbuildanapp.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        return todos;
    }

    void createTodo(Todo todo) {
        todoRepository.save(todo);
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
