package com.project.Tiendaa.service;

import com.project.Tiendaa.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);

}
