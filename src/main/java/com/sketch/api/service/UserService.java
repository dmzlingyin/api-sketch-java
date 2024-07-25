package com.sketch.api.service;

import com.sketch.api.model.dto.UserDTO;

public interface UserService {
    String find(String name);
    void create(UserDTO user);
}
