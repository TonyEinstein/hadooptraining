package com.training.hadoop.HDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by ua07 on 9/20/19.
 */
public class DeleteFile {
    public static void main(String[] arg) throws Exception{
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri,conf,"ua07");
        Path path = new Path("/user/ua07/twoTestDir/test7.txt"); //hdfs dir
        fs.delete(path);
        fs.close();
        System.out.print("OK");
    }
}
