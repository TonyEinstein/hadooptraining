package com.training.hadoop.hbase;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua07 on 10/15/19.
 */


public class Create_table {

    /**
     *
     * @param admin
     * @param tablename
     * @throws IOException
     */
    private void createTable(HBaseAdmin admin, String tablename) throws IOException {
        HTableDescriptor tdesc=new HTableDescriptor(tablename); //table name :emp1713406107

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

    /**
     *
     * @param conf
     * @param tablename
     * @param rownum
     * @param infoname
     * @param colunmnName
     * @param value
     * @throws IOException
     */
    private void insertOne(Configuration conf,String tablename,String rownum,String infoname,String colunmnName,String value) throws IOException {
        HTable table = new HTable(conf,tablename);

        Put put =  new Put(Bytes.toBytes(rownum));
        put.addColumn(
                Bytes.toBytes(infoname),
                Bytes.toBytes(colunmnName),
                Bytes.toBytes(value)
                );
        table.put(put);
        table.close();
    }

    private void get(Configuration conf,String tablename,String rownum,String infoname,String columnname) throws IOException {
        HTable table = new HTable(conf,tablename);
        Get get = new Get(Bytes.toBytes(rownum));
        Result record = table.get(get);

        String name = Bytes.toString(record.getValue(Bytes.toBytes(infoname),Bytes.toBytes(columnname)));
        System.out.println(name);
        table.close();

    }

    /**
     *
     * @param conf
     * @param tablename
     * @param rownum
     * @param infoname
     * @param columnnames
     * @throws IOException
     */
    private void scan(Configuration conf,String tablename,String rownum,String infoname,String columnnames) throws IOException {
        HTable table = new HTable(conf,tablename);
        Scan scanner = new Scan(); // as select * from tablename
//        scanner.setFilter(filter); // run filter
        ResultScanner rs = table.getScanner(scanner); //excute search
        String[] columns = columnnames.split("-");
        for (Result r:rs) {
            String name = Bytes.toString(r.getValue(Bytes.toBytes(infoname),Bytes.toBytes(columns[0])));
            String age = Bytes.toString(r.getValue(Bytes.toBytes(infoname),Bytes.toBytes(columns[1])));
            System.out.println(name+"  "+age);
        }
        table.close();

    }

    /**
     *
     * @param conf
     * @param tablename
     * @throws IOException
     */
    private void delete(Configuration conf,String tablename) throws IOException {
        HBaseAdmin client = new HBaseAdmin(conf);
        client.disableTable(tablename);
        client.deleteTable(tablename);
        client.close();
    }


    /**
     *
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum","xdata-m0,xdata-m1,xdata-m2");
        HBaseAdmin admin = new HBaseAdmin(conf);

    }
}
