package com.letsbuildanapp.todoapp.User;

import com.letsbuildanapp.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProcess {

    private final UserRepository userRepository;

    @Autowired
    public UserProcess(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
