package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@RequiredArgsConstructor
@Table(
    name = "user",
    indexes = {@Index(columnList = "nickname", unique = true)})
@ToString(callSuper = true)
public class User extends BaseEntity {

  @Column(
      name = "nickname",
      nullable = false,
      unique = true,
      columnDefinition = "varchar(36) default ''")
  @NonNull
  private String nickname;

  @Column(name = "password", nullable = false, columnDefinition = "varchar(36) default ''")
  @NonNull
  private String password;
}
