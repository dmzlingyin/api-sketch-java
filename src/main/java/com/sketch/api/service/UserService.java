package com.sketch.api.service;

import com.sketch.api.model.dto.UserDTO;
import com.sketch.api.util.Response;

public interface UserService {
    String find(String name);
    void create(UserDTO user);
}
