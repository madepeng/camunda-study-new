package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName S2
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/27
 * @Version V1.0
 **/
public class S2 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("s2");
    }
}
