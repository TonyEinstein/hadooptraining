package com.training.hadoop.HDFS;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import java.net.URI;

/**
 * Created by ua07 on 9/20/19.
 */
public class DownLoadFile {
    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri, conf, "ua07");

        Path src =new Path("/user/ua07/twoTestDir/yourname.txt"); //hdfs
        Path dst =new Path("/home/ua07/myProject/src/main/java/ltd/myProject/test8.txt");//local

        fs.copyToLocalFile(src,dst);

        fs.close();
        System.out.print("OK");
    }
}
