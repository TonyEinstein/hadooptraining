package com.training.hadoop.HDFS;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ua07 on 9/20/19.
 */
public class CatFile {
    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri, conf, "ua07");

        Path path = new Path("/user/ua07/twoTestDir/yourname.txt");  //hdfs file

        FileStatus fileStatus = fs.getFileLinkStatus(path); //file Status

        long blockSize = fileStatus.getBlockSize(); //blockSize
        System.out.println("blockSize:"+blockSize);

        long fileSize = fileStatus.getLen(); //file Size
        System.out.println("fileSize:"+fileSize);

        String fileOwner = fileStatus.getOwner(); //file Owner
        System.out.println("fileOwner:"+fileOwner);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); //tshangcichange time
        long accessTime = fileStatus.getAccessTime();
        System.out.println("accessTime:"+sdf.format(new Date(accessTime)));

        long modifyTime = fileStatus.getModificationTime(); //last change time
        System.out.println("modifyTime:"+sdf.format(new Date(modifyTime)));

        fs.close();

    }
}
