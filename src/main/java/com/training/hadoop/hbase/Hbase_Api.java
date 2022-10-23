package com.training.hadoop.hbase;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua07 on 9/29/19.
 */
public class Hbase_Api {

    /**
     *
     * @param admin
     * @param tableName
     * @throws IOException
     */
    protected static void createTable1(HBaseAdmin admin,String tableName) throws IOException {
        HTableDescriptor tdesc=new HTableDescriptor(tableName); //table name :emp1713406107

        HColumnDescriptor colDesc=new HColumnDescriptor("F1");
        tdesc.addFamily(colDesc);
        tdesc.addFamily(new HColumnDescriptor("F2"));

        admin.createTable(tdesc);
        System.out.println("create OK");
        admin.close();
    }

    /**
     *
     * @param conf
     * @param tableName
     * @throws IOException
     */
    protected static void addData(Configuration conf,String tableName) throws IOException {
        HTable table = new HTable(conf,tableName);
        List<Put> putList = new ArrayList<Put>();
        Put put = new Put(Bytes.toBytes("001"));
        put.addColumn(Bytes.toBytes("F1"), Bytes.toBytes("name"), Bytes.toBytes("harry"));
        put.addColumn(Bytes.toBytes("F1"), Bytes.toBytes("age"), Bytes.toBytes("66"));
        put.addColumn(Bytes.toBytes("F1"), Bytes.toBytes("sex"), Bytes.toBytes("unknown"));

        putList.add(put);

        put = new Put(Bytes.toBytes("002"));
        put.addColumn(Bytes.toBytes("F2"), Bytes.toBytes("name"), Bytes.toBytes("potter"));
        put.addColumn(Bytes.toBytes("F2"), Bytes.toBytes("age"), Bytes.toBytes("33"));
        put.addColumn(Bytes.toBytes("F2"), Bytes.toBytes("sex"), Bytes.toBytes("male"));
        putList.add(put);

        table.put(putList);
        System.out.println("add data OK");
        table.close();


    }


    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum","xdata-m0,xdata-m1,xdata-m2");
        HBaseAdmin admin = new HBaseAdmin(conf);

        Hbase_Api.createTable1(admin,"member7777");
        Hbase_Api.addData(conf,"member7777");




    }
}
