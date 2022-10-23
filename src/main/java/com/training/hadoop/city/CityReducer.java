package com.training.hadoop.city;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;

import java.net.URI;

/**
 * Created by ua07 on 9/29/19.
 */
public class CityReducer {
    public static void main(String[] arg) throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://xdata-m0:8020");
        FileSystem fs = FileSystem.get(uri, conf, "ua07");
    }
}
