package com.shareniu.Test.gateway;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * @ClassName Service2
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/18
 * @Version V1.0
 **/
public class Service2 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("s2 start:" + new Date());
        Thread.sleep(5000);
        System.out.println("s2 end:" + new Date());
    }
}
