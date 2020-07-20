package com.ke;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class HbaseConnTest {

    private Configuration configuration;

    private Connection connection;

    @BeforeEach
    public void init() throws IOException {
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","bigdata");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        connection = ConnectionFactory.createConnection(configuration);
    }

    @AfterEach
    public void teardown() throws IOException {
        if (connection != null && !connection.isClosed()){
            connection.close();
        }
    }



    @Test
    public void createTable() throws IOException {
        Admin admin = connection.getAdmin();
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf("MyTable"));

        for (String col : Arrays.asList("f1","f2","f3")){
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(col);
            hColumnDescriptor.setMaxVersions(1);
                hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
    }

    @Test
    public void deleteTable() throws IOException {
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf("MyTable"));
        admin.deleteTable(TableName.valueOf("MyTable"));
    }

    @Test
    public void getTable() throws IOException {
        Admin admin = connection.getAdmin();
        HTableDescriptor myTable = admin.getTableDescriptor(TableName.valueOf("MyTable"));
        System.out.println(myTable.toString());
        Assertions.assertNotNull(myTable);
    }

    @Test
    public void insert() throws IOException {
        Table myTable = connection.getTable(TableName.valueOf("MyTable"));
        Put put = new Put("rowkey1".getBytes());
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("name"),Bytes.toBytes("小花"));
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("type"),Bytes.toBytes("dog"));
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("age"),Bytes.toBytes("20"));
        myTable.put(put);
    }

    @Test
    public  void getRow() throws IOException {
        Table myTable = connection.getTable(TableName.valueOf("MyTable"));
        Get get = new Get(Bytes.toBytes("rowkey1"));
        Result result = myTable.get(get);
        System.out.println(result.getValue(Bytes.toBytes("f1"),Bytes.toBytes("name")));
        Assertions.assertNotNull(result);
    }


}
