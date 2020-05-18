package com.shareniu.Test.timer;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Date;

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
        System.out.println("service2:" + new Date());
    }
}
