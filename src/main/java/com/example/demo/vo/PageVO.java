package com.example.demo.vo;


import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageVO<T> {

  private long total;
  private List<T> dataList;

  public PageVO(Page<T> page) {
    this.setTotal(page.getTotalElements());
    this.setDataList(page.getContent());
  }

  public PageVO(Page<T> page, boolean setData) {
    this.setTotal(page.getTotalElements());
    if (setData) {
      this.setDataList(page.getContent());
    }
  }
}
