package com.ahmethkaya.issuemanagement.service;

import com.ahmethkaya.issuemanagement.dto.UserDto;
import com.ahmethkaya.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);

}
