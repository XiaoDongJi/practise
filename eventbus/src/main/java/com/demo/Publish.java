package com.demo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Publish {

    static class Listener {

        @Subscribe
        public void listen(String eventData) {
            System.out.println("接收到事件数据：" + eventData);
        }

    }


    public static void main(String[] args) {

        EventBus eventBus = new EventBus();
        eventBus.register(new Listener());
        eventBus.post("ddddd");
    }
}
