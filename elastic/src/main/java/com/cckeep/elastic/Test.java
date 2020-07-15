package com.cckeep.elastic;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws UnknownHostException {

        Settings settings = Settings.builder().put("cluster.name", "crmdata-test")
                //.put("client.transport.sniff", true)// 开启嗅探 , 开启后会一直连接不上, 原因未知
                .put("client.transport.nodes_sampler_interval", 10, TimeUnit.SECONDS) //报错,
                .put("client.transport.ping_timeout", 10, TimeUnit.SECONDS) // 报错, ping等待时间,
                .build();
        TransportClient client = TransportClient.builder()
                .settings(settings).build();
        TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("10.216.4.139"),9300);
        client.addTransportAddress(address);

    }


}
