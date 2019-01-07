package com.cckeep.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws InterruptedException {

        try {
            System.out.println("1122");
            System.out.println("dddd");
            int[] aa = new int[]{1,2,3};
            int b = aa[4];
            System.out.println("ccc");
        }catch (Exception e){


            System.out.println("----------------");

            logger.error("ddd",e);


        }


    }

}
