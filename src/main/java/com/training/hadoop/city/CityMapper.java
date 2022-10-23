package com.training.hadoop.city;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


/**
 * Created by ua07 on 9/29/19.
 */
public class CityMapper extends TableMapper<Text,IntWritable>{

}
