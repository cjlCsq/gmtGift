package com.example.demo.biz;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.request.AddUserRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class AddUserBiz extends TransactionBiz<AddUserRequest, Object> {

  private final UserRepository userRepository;

  public AddUserBiz(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected void validateRequest(AddUserRequest request) throws InvalidInputException {
    if (StringUtils.isBlank(request.getNickname())) {
      throw new InvalidInputException("invalid-nickname", "无效的参数nickname");
    }
    if (StringUtils.isBlank(request.getPassword())) {
      throw new InvalidInputException("invalid-password", "无效的参数password");
    }
  }

  @Override
  protected Object doBiz(AddUserRequest request) {
    return userRepository.save(new User(request.getNickname(), request.getPassword()));
  }
}
