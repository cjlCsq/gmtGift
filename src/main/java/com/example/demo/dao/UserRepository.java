package com.example.demo.dao;

import com.example.demo.dto.UserNameDTO;
import com.example.demo.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

  @Query(value = "SELECT nickname FROM `user`", nativeQuery = true)
  List<UserNameDTO> queryUserName();


  Page<User> findAllBy(Pageable pageable);
}
