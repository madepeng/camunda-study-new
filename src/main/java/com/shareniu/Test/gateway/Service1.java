package com.shareniu.Test.gateway;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * @ClassName Service1
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/18
 * @Version V1.0
 **/
public class Service1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("s1 start：" + new Date());
        Thread.sleep(10000);
        System.out.println("s2 end：" + new Date());
    }
}
