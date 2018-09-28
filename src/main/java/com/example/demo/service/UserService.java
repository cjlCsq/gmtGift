package com.example.demo.service;

import com.example.demo.dto.UserNameDTO;
import com.example.demo.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

  List<UserNameDTO> getUsersName();

  Page<User> getUsers(int pageIndex, int pageSize);
}
