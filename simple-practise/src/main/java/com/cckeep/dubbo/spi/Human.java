package com.cckeep.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("man")
public interface Human {

    @Adaptive("who")
    void say(URL url);

}
