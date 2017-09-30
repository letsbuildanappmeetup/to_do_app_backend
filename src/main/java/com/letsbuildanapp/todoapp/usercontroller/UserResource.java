package com.letsbuildanapp.todoapp.usercontroller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    private final UserProcess userProcess;

    public UserResource(final UserProcess userProcess) {
        this.userProcess = userProcess;
    }
}
