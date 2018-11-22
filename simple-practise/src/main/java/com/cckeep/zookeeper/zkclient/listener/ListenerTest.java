package com.cckeep.zookeeper.zkclient.listener;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;

import java.util.List;

public class ListenerTest {
    public static void main(String[] args) throws InterruptedException {
        String path = "/keep";
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 500);
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("notify:"+parentPath+",childrens:"+currentChilds);
            }
        });

        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                if (state == Watcher.Event.KeeperState.Disconnected){
                    //断开连接
                    System.out.println("Disconnected....");

                }else if (state == Watcher.Event.KeeperState.SyncConnected){
                    //建立连接
                    System.out.println("SyncConnected");
                }
            }

            @Override
            public void handleNewSession() throws Exception {
                //session过期
                System.out.println("session expired");
            }
        });
        zkClient.createPersistent(path);
        zkClient.createEphemeral(path+"/c1",1);


        /*zkClient.createPersistent(path);
        Thread.sleep(1000);
        zkClient.createPersistent(path+"/p1");
        Thread.sleep(1000);
        zkClient.delete(path+"/p1");*/
        Thread.sleep(Integer.MAX_VALUE);
    }








}
