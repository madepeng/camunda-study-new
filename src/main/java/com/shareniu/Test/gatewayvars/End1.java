package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName End1
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/28
 * @Version V1.0
 **/
public class End1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("end1");
    }
}
