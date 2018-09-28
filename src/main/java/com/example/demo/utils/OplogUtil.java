package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OplogUtil {

  private static final String APPEND_NAME = "OpLog";
  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final Logger logger = LoggerFactory.getLogger(APPEND_NAME);

  public static void info(long userId, String action, String result) {
    logger.info(
        JSON.toJSONString(new LoggerEntity(userId, action, result, sdf.format(new Date()))));
  }

  @Value
  static class LoggerEntity {

    private long userId;
    private String action;
    private String result;
    private String time;
  }
}
