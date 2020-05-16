package com.shareniu.Test.cancel;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Service1Compension
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class Service1Compension implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("service1 compension");
    }
}
