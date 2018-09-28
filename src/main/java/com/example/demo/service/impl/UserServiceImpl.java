package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserNameDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserNameDTO> getUsersName() {
    return userRepository.queryUserName();
  }

  @Override
  public Page<User> getUsers(int pageIndex, int pageSize) {
    return userRepository.findAllBy(PageRequest.of(pageIndex, pageSize));
  }
}
