package com.shareniu.Test.var;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Service2
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/16
 * @Version V1.0
 **/
public class Service2 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("service2 var:" + execution.getVariable("a"));
        System.out.println("service2 var:" + execution.getVariable("c"));
        System.out.println("service2 var:" + execution.getVariable("f"));
        System.out.println("service2 var:" + execution.getVariable("g"));
    }
}
