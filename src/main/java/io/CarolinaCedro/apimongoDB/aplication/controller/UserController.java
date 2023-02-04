package io.CarolinaCedro.apimongoDB.aplication.controller;

import io.CarolinaCedro.apimongoDB.aplication.dto.request.UserRequestDto;
import io.CarolinaCedro.apimongoDB.aplication.dto.response.UserResponseDto;
import io.CarolinaCedro.apimongoDB.aplication.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mongo")
public class UserController {

    private final ServiceImpl service;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDto> gettAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserResponseDto> findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create (@RequestBody UserRequestDto requestDto){
        return service.createUser(requestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserResponseDto update(@PathVariable String id,@RequestBody  UserRequestDto request){
        return service.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id){
        service.deleteById(id);
    }


}
