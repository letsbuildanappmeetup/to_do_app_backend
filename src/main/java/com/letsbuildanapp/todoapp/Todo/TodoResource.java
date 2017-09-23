package com.letsbuildanapp.todoapp.Todo;

import com.letsbuildanapp.todoapp.data.Todo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class TodoResource {

    private final TodoProcess todoProcess;

    public TodoResource(final TodoProcess todoProcess) {
        this.todoProcess = todoProcess;
    }

    @RequestMapping("/")
    public String getGreetings() {
        return "To do APP!!!";
    }

    @RequestMapping(value = "/todo")
    public Todo getTodos(@RequestParam(value = "title") String title) {
        Todo oneTodo = todoProcess.getOneTodo(title);
        System.out.println(oneTodo);
        return oneTodo;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json")
    public List<Todo> getAllTodos() {
        List<Todo> todos = todoProcess.getAllTodos();
        if (todos != null) {
            System.out.println(todos);
            return todos;
        }
        return Collections.emptyList();
    }
}
