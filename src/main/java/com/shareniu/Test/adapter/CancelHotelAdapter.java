package com.shareniu.Test.adapter;

import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CancelHotelAdapter implements JavaDelegate {

  @Override
  public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {

    System.out.println("cancel hotel");

  }

}
