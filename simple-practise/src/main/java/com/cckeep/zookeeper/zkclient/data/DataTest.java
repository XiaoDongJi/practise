package com.cckeep.zookeeper.zkclient.data;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class DataTest {

    public static void main(String[] args) throws InterruptedException {
        String path = "/keep";
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 500);
        zkClient.createEphemeral(path,123);
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("node "+dataPath+" change,data: "+data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node "+dataPath+" deleted");
            }
        });
       System.out.println(""+zkClient.readData(path));

        zkClient.writeData(path,"456");
        Thread.sleep(1000);
        zkClient.delete(path);
        Thread.sleep(Integer.MAX_VALUE);





    }


}
