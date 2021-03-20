package com.cckeep.test;

import com.sun.management.VMOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.HotSpotDiagnostic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {


    public static void main(String[] args) {

        HotSpotDiagnostic mxBean = new HotSpotDiagnostic();
        List<VMOption> diagnosticVMOptions = mxBean.getDiagnosticOptions();
        for (VMOption vmOption:diagnosticVMOptions){
            System.out.println(vmOption.getName() + " = " + vmOption.getValue());
        }

    }
}
