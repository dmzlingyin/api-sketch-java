package com.sketch.api.service.impl;

import com.sketch.api.repository.UserRepository;
import com.sketch.api.service.UserService;
import com.sketch.api.util.Response;
import com.sketch.api.util.ResponseUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
    public Response find(String name) {
        this.logger.info(name);
        String res = this.userRepository.findByName(name).getName();
        return ResponseUtil.response(0, "", new HashMap<String, Object>(){{put("name", res);}});
    }

}
