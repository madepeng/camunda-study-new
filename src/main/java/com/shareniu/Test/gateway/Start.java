package com.shareniu.Test.gateway;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Start
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/18
 * @Version V1.0
 **/
public class Start implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("start");
    }
}