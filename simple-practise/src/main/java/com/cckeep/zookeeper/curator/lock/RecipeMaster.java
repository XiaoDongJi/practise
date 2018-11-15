package com.cckeep.zookeeper.curator.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * master选举
 */
public class RecipeMaster {

    public static String path = "/curator_master";
    final static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws InterruptedException {
        client.start();
        LeaderSelector selector = new LeaderSelector(client, path, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                System.out.println("master role");
                Thread.sleep(2000);
                System.out.println("master release");
            }
        });

        selector.autoRequeue();
        selector.start();
        Thread.sleep(Integer.MAX_VALUE);
    }

}
