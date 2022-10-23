package com.training.hadoop.HDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by ua07 on 9/20/19.
 */
public class CreateFile {
    public static void main( String[] args ) throws Exception
    {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri,conf,"ua07");
        Path dfs = new Path("/user/ua07/twoTestDir/test8.txt"); //file in will creat
        FSDataOutputStream os = fs.create(dfs,true);
        os.writeBytes("hello,ruhai \n hadoop i am");
        os.close();
        fs.close();
        System.out.print("OK");
    }
}

