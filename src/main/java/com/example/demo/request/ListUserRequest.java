package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListUserRequest {

  private Integer pageIndex;
  private Integer pageSize;
}
