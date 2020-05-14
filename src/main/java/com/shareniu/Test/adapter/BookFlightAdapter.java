package com.shareniu.Test.adapter;

import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BookFlightAdapter implements JavaDelegate {

  @Override
  public void execute(org.camunda.bpm.engine.delegate.DelegateExecution execution) throws Exception {

     System.out.println("book flight crashes");
     
     if (true) {
       throw new RuntimeException("Flight booking did not work");
     }
    
  }



}
