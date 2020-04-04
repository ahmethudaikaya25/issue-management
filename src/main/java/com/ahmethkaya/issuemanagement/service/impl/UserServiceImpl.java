package com.ahmethkaya.issuemanagement.service.impl;

import com.ahmethkaya.issuemanagement.dto.UserDto;
import com.ahmethkaya.issuemanagement.entity.User;
import com.ahmethkaya.issuemanagement.repository.UserRepository;
import com.ahmethkaya.issuemanagement.service.UserService;
import com.ahmethkaya.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto user) {
        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);
        user.setId(u.getId());
        return user;
    }

    @Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> response = new TPage<UserDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return response;
    }

    @Override
    public UserDto getByUsername(String username) {
        User u = userRepository.findByUsername(username);
        return modelMapper.map(u, UserDto.class);

    }
}
