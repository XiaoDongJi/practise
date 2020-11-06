package com.cckeep.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class Test {


    public static void main(String[] args) {

        Map[] states = {
           new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}}, //0
                new HashMap(){{put('d',2);put('.',4);}},//1
                new HashMap(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},//2
                new HashMap(){{put('d',3);put('e',5);put(' ',8);}},//3
                new HashMap(){{put('d',3);}},//4
                new HashMap(){{put('s',6);put('d',7);}},//5
                new HashMap(){{put('d',7);}},//6
                new HashMap(){{put('d',7);put(' ',8);}},//7
                new HashMap(){{put(' ',8);}},//8
        } ;

    }
}
