package com.example.demo.biz;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.request.ListUserRequest;
import com.example.demo.service.UserService;
import com.example.demo.vo.PageVO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ListUserBiz extends BaseBiz<ListUserRequest, PageVO<User>> {

  private final UserService userService;

  public ListUserBiz(final UserService userService) {
    this.userService = userService;
  }

  @Override
  protected void validateRequest(ListUserRequest request) throws InvalidInputException {
    if (request.getPageIndex() < 1) {
      throw new InvalidInputException("invalid-page-index", "无效的pageIndex");
    }
    if (request.getPageSize() < 1) {
      throw new InvalidInputException("invalid-page-size", "无效的pageSize");
    }
  }

  @Override
  protected PageVO<User> doBiz(ListUserRequest request) {
    final Page<User> page = userService.getUsers(request.getPageIndex() - 1, request.getPageSize());
    PageVO pageVO = new PageVO(page);
    return pageVO;
  }
}
