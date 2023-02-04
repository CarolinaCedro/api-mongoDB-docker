package io.CarolinaCedro.apimongoDB.aplication.service;

import io.CarolinaCedro.apimongoDB.aplication.dto.request.UserRequestDto;
import io.CarolinaCedro.apimongoDB.aplication.dto.response.UserResponseDto;
import io.CarolinaCedro.apimongoDB.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();
    Optional<UserResponseDto>findById(String id);
    UserResponseDto createUser(UserRequestDto request);
    UserResponseDto updateUser(String id,UserRequestDto request);
    void deleteById(String id);
}
