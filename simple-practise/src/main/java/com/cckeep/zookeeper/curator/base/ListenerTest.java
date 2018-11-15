package com.cckeep.zookeeper.curator.base;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ListenerTest {

    public static String path = "/basetest";
    final static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws Exception {
        client.start();

        //node(client);
        //path(client);
        System.out.println(Integer.MAX_VALUE);






    }

    public static void node(CuratorFramework client) throws Exception {
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL).forPath(path,"init".getBytes());
        final NodeCache nodeCache = new NodeCache(client,path,false);
        nodeCache.start(true);

        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("node update ,new data "+new String(nodeCache.getCurrentData().getData()));
            }
        });

        client.setData().forPath(path,"u".getBytes());

        Thread.sleep(1000);
        client.delete().deletingChildrenIfNeeded().forPath(path);

        Thread.sleep(Integer.MAX_VALUE);
    }

    public static void path(CuratorFramework client) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(client,path,true);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                switch(pathChildrenCacheEvent.getType()){
                    case CHILD_ADDED:
                        System.out.println("added :"+pathChildrenCacheEvent.getData().getPath());
                        break;
                    case CHILD_UPDATED:
                        System.out.println("update: "+pathChildrenCacheEvent.getData().getPath());
                        break;
                    case CHILD_REMOVED:
                        System.out.println("delete: "+pathChildrenCacheEvent.getData().getPath());
                        break;
                }
            }
        });

        client.create().withMode(CreateMode.PERSISTENT).forPath(path);
        Thread.sleep(1000);
        client.create().withMode(CreateMode.PERSISTENT).forPath(path + "C1");
        Thread.sleep(1000);
        client.delete().forPath(path + "C1");
        Thread.sleep(Integer.MAX_VALUE);
    }


}
