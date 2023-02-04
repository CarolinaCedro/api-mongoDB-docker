package io.CarolinaCedro.apimongoDB.aplication.service.impl;

import io.CarolinaCedro.apimongoDB.aplication.dto.request.UserRequestDto;
import io.CarolinaCedro.apimongoDB.aplication.dto.response.UserResponseDto;
import io.CarolinaCedro.apimongoDB.aplication.service.UserService;
import io.CarolinaCedro.apimongoDB.config.ModelMapperConfig;
import io.CarolinaCedro.apimongoDB.model.User;
import io.CarolinaCedro.apimongoDB.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements UserService {


    private final UserRepository repository;
    private final ModelMapperConfig modelMapper;


    @Override
    public List<UserResponseDto> findAll() {
        return repository.findAll().stream().map(this::dto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponseDto> findById(String id) {
        return repository.findById(id).map(this::dto);
    }

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto request) {
        User user = repository.save(modelMapper.mapper().map(request,User.class));
        return modelMapper.mapper().map(user,UserResponseDto.class);
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(String id,UserRequestDto request) {
        Assert.notNull(id, "Unable to update registration");
        Optional<User> optional = Optional.ofNullable(repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Usuario não encontrado")
        ));

        User response = new User();
        if (optional.isPresent()) {
            User db = optional.get();

            db.setName(request.getName());
            db.setAge(request.getAge());
            db.setLastname(request.getLastname());
            db.setPhone(request.getPhone());
            repository.save(db);
            response = db;
        }
        return modelMapper.mapper().map(response,UserResponseDto.class);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public UserResponseDto dto (User user){
        return modelMapper.mapper().map(user,UserResponseDto.class);
    }

}
