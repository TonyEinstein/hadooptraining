package com.training.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * hadoop test
 *
 */

public class App {
    /**
     *
     * @param args
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    public static void main( String[] args ) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
//        URI uri = new URI("hdfs://xdata-m0:8020");
        URI uri = new URI("hdfs://192.168.77.12:8020");
        FileSystem fs = FileSystem.get(uri,conf,"root");
        Path dfs = new Path("/test/test.txt");
        FSDataOutputStream os = fs.create(dfs,true);
        os.writeBytes("hello,first test");
        System.out.println("OK");
        os.close();
        fs.close();
    }
}
