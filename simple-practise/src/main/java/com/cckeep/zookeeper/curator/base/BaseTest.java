package com.cckeep.zookeeper.curator.base;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * 基本用法  fluent 设计api
 */
public class BaseTest {

    public static String path = "/basetest";
    final static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();


    public static void main(String[] args) throws Exception {

        client.start();

        //client.create().withMode(CreateMode.EPHEMERAL).forPath(path,"init".getBytes());

        //client.create().withMode(CreateMode.EPHEMERAL).forPath(path+"/a1","123".getBytes());

        //client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/basetest/a1/c1");

        //client.delete().deletingChildrenIfNeeded().forPath(path);

        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path+"/c1","init".getBytes());
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath(path+"/c1");

        client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath(path+"/c1");




    }

}
