package com.cckeep.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("who","woman");
        URL url = new URL("dubbo","127.0.0.1",8080,paramMap);
        Human adaptiveExtension = ExtensionLoader.getExtensionLoader(Human.class).getAdaptiveExtension();
        adaptiveExtension.say(url);

    }

}
