package com.training.hadoop.HDFS;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.lang.ObjectUtils;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * Created by ua07 on 9/20/19.
 */
public class ReadFile {
    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri, conf, "ua07");
        Path path = new Path("/user/ua07/twoTestDir/test01.txt");
        /*
        1.seek
         */
//        FSDataInputStream in =null;
//        try{
//            in = fs.open(path);
//            IOUtils.copyBytes(in,System.out,4096,false);
//            //in.seek(0); //
//        }finally {
//            IOUtils.closeStream(in);
//        }
        /*2.readUTF()
        error
         */
//        FSDataInputStream in = fs.open(path);
//        try {
//            String string = in.readUTF();
//            System.out.println(string);
//        } finally {
//            System.out.println("OK");
//        }

        /*
        readline()
         */
        FSDataInputStream in = fs.open(path);
        String strs =null;
        while ( (strs = in.readLine()) != null){
            System.out.println(strs);
        }

        fs.close();
    }
}
