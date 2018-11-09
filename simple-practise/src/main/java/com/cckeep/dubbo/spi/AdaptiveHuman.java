package com.cckeep.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;


public class AdaptiveHuman implements Human {

    @Override
    public void say(URL url) {
        Human man = ExtensionLoader.getExtensionLoader(Human.class).getExtension("woman");
        man.say(url);
    }
}
