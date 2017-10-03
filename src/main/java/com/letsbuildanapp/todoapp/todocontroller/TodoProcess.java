package com.letsbuildanapp.todoapp.todocontroller;

import com.datastax.driver.core.utils.UUIDs;
import com.letsbuildanapp.todoapp.model.Todo;
import com.letsbuildanapp.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TodoProcess {

    private final static Logger logger = Logger.getLogger(TodoProcess.class);
    private final TodoRepository todoRepository;

    @Autowired
    public TodoProcess(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    Todo getOneTodo(String title) {
        Todo todo = todoRepository.findByTitle(title);
        logger.info("This is info todos : " + todo);
        return todo;
    }

    List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        Iterable<Todo> toDosRepositoryAll = this.todoRepository.findAll();
        toDosRepositoryAll.forEach(todos::add);
        logger.info("This is info todos : " + todos);
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
