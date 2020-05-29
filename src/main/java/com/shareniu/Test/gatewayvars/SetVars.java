package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.math.BigDecimal;

/**
 * @ClassName SetVars
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/27
 * @Version V1.0
 **/
public class SetVars implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("a" ,1);
        execution.setVariable("b" ,2);
        execution.setVariable("c" ,3);
        execution.setVariable("ff" ,true);
        execution.setVariable("tradeAmount" ,new BigDecimal("5.44"));
        execution.setVariable("vailBalcance" ,BigDecimal.valueOf(3.33));

    }
}
