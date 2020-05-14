package com.shareniu.Test.adapter;

import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BookHotelAdapter implements JavaDelegate {

  @Override
  public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {

    System.out.println("book hotel car");

  }

}
