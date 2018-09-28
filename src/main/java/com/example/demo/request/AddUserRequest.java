package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserRequest {

  private String nickname;
  private String password;
}
