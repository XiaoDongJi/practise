package com.cckeep.dubbo.spi;

import com.alibaba.dubbo.common.URL;

public class Man implements Human {
    @Override
    public void say(URL url) {
        System.out.println("hi,i'm man");
    }
}
