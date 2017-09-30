package com.letsbuildanapp.todoapp.Todo;

import com.letsbuildanapp.todoapp.data.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/todo")
public class TodoResource {

    private final TodoProcess todoProcess;

    public TodoResource(final TodoProcess todoProcess) {
        this.todoProcess = todoProcess;
    }

    @RequestMapping("/")
    public String getGreetings() {
        return "To do APP!!!";
    }

    @RequestMapping(value = "/one")
    public Todo getTodos(@RequestParam(value = "title") String title) {
        return todoProcess.getOneTodo(title);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Todo> getAllTodos() {
        return todoProcess.getAllTodos();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createTodo(@RequestBody Todo todo) {
        todoProcess.createTodo(todo);
    }

    @RequestMapping(value = "/update-desc", method = RequestMethod.PUT)
    public void updateTodoDescription(@RequestParam(value = "uuid") UUID uuid, @RequestParam(value = "description") String description) {
        todoProcess.updateTodoDesc(uuid, description);
    }

    @RequestMapping(value = "/update-title", method = RequestMethod.PUT)
    public void updateTodoTitle(@RequestParam(value = "uuid") UUID uuid, @RequestParam(value = "title") String title) {
        todoProcess.updateTodoTitle(uuid, title);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteTodo(@RequestParam(value = "uuid") UUID uuid) {
        todoProcess.deleteTodo(uuid);
    }
}
