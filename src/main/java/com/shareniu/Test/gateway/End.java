package com.shareniu.Test.gateway;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName End
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/18
 * @Version V1.0
 **/
public class End implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("end");
    }
}
