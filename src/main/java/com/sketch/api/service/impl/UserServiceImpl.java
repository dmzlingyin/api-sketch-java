package com.sketch.api.service.impl;

import com.sketch.api.model.User;
import com.sketch.api.model.dto.UserDTO;
import com.sketch.api.repository.UserRepository;
import com.sketch.api.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(Logger logger, UserRepository userRepository) {
        this.logger = logger;
        this.userRepository = userRepository;
    }

    @Override
    public String find(String name) {
        this.logger.info(name);
        return this.userRepository.findByName(name).getName();
    }

    @Override
    public void create(UserDTO user) {
        this.userRepository.insert(new User(user.getName(), user.getEmail()));
    }

}
