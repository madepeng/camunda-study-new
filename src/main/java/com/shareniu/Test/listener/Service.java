package com.shareniu.Test.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Service
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/23
 * @Version V1.0
 **/
public class Service implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("service");
    }
}
