package com.project.Tiendaa.service;

import com.project.Tiendaa.dto.UserDTO;

import com.project.Tiendaa.model.RoleEntity;
import com.project.Tiendaa.model.UserEntity;
import com.project.Tiendaa.repository.RoleRepository;
import com.project.Tiendaa.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado!"));
        return new UserDTO(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getRole()
        );
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        RoleEntity roles = roleRepository.findByRoleName(userDTO.getRole().getId().toString())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado!"));

        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .role(roles)
                .build();

        userEntity = userRepository.save(userEntity);

        return new UserDTO(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getRole()
        );
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(
                        user.getUsername(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getRole()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuario no encontrado!");
        }
        userRepository.deleteById(id);
    }
}
