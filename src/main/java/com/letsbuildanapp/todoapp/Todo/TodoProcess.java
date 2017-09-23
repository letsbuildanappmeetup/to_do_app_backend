package com.letsbuildanapp.todoapp.Todo;

import com.letsbuildanapp.todoapp.data.Todo;
import com.letsbuildanapp.todoapp.repository.TodoRepository;
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

    public Todo getOneTodo(String title) {
        return todoRepository.findByTitle(title);
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        for (Todo todo : this.todoRepository.findAll()) {
            todos.add(todo);
        }
        return todos;
    }
}
