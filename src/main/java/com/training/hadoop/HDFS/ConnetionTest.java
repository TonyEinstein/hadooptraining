package com.training.hadoop.HDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ConnetionTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri,conf,"ua07");
        Path dfs = new Path("/user/ua07/twoTestDir/yourname.txt");
        FSDataOutputStream os = fs.create(dfs,true);
        os.writeBytes("hello,haihai");
        os.close();
        fs.close();
    }
}
