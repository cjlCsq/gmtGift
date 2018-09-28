package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(of = "id")
@ToString
@JSONType(ignores = {"createdTime", "lastModified"})
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @CreatedDate
  @Column(
      name = "created_time",
      updatable = false,
      nullable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date createdTime;

  @LastModifiedDate
  @Column(
      name = "last_modified",
      nullable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date lastModified;

}
