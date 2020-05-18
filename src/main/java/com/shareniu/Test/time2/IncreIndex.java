package com.shareniu.Test.time2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Date;

/**
 * @ClassName IncreIndex
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/16
 * @Version V1.0
 **/
public class IncreIndex implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer index = (Integer)execution.getVariable("index");
        System.out.println(new Date() + ",incre,before,index:" + index);
        index ++;
        execution.setVariable("index", index);
        System.out.println(new Date() + ",incre,aftre,index:" + index);
    }
}
