package com.shareniu.Test.adapter;

import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CancelCarAdapter implements JavaDelegate {

  @Override
  public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {

     System.out.println("cancel car");
    
  }

}
