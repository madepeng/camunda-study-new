package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.math.BigDecimal;

/**
 * @ClassName Calculate
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/29
 * @Version V1.0
 **/
public class Calculate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        BigDecimal tradeAmount = (BigDecimal)execution.getVariable("tradeAmount");
        BigDecimal vailBalcance = (BigDecimal)execution.getVariable("vailBalcance");
        execution.setVariable("result", tradeAmount.subtract(vailBalcance));
    }
}
