package com.epam.module3.task1.generated;

import java.lang.Boolean;
import java.lang.System;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Volkswagen implements ICar {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Boolean start() {
    System.out.println("{This's STOP method. ClassLoader = "+ this.getClass().getClassLoader());
    return true;
  }

  public Boolean stop() {
    logger.debug("Method stop is running..");
    System.out.println("{This's STOP method. ClassLoader = "+ this.getClass().getClassLoader());
    logger.debug("Method stop finish");
    return false;
  }

  public void additionalMethod() {
    logger.debug("Method additionalMethod is running..");
    System.out.println("{This's Additional method. ClassLoader = "+ this.getClass().getClassLoader());
    logger.debug("Method additionalMethod stopped..");
  }
}
