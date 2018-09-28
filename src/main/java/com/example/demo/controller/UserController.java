package com.example.demo.controller;

import com.example.demo.biz.AddUserBiz;
import com.example.demo.biz.ListUserBiz;
import com.example.demo.request.AddUserRequest;
import com.example.demo.request.ListUserRequest;
import com.example.demo.result.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

  private ListUserBiz listUserBiz;
  private AddUserBiz addUserBiz;

  public UserController(final ListUserBiz listUserBiz, final AddUserBiz addUserBiz) {
    this.listUserBiz = listUserBiz;
    this.addUserBiz = addUserBiz;
  }

  @RequestMapping(value = "/list-user", method = RequestMethod.GET)
  public Response listUser(ListUserRequest request) {
    return new Response<>(listUserBiz.process(request));
  }

  @RequestMapping(value = "/add-user", method = RequestMethod.POST)
  public Response addUser(AddUserRequest request) {
    return new Response<>(addUserBiz.process(request));
  }


}
