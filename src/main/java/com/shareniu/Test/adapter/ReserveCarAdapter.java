package com.shareniu.Test.adapter;

import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReserveCarAdapter implements JavaDelegate {

  @Override
  public void execute(org.camunda.bpm.engine.delegate.DelegateExecution ctx) throws Exception {

    System.out.println("reserve car for '" + ctx.getVariable("name") + "'");

  }

}
