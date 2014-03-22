package com.lmb.mapreduce.countbuy;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context)
			throws IOException, InterruptedException {
		int count = 0;
		Iterator<IntWritable> iterator = values.iterator();
		while (iterator.hasNext()) {
			count = count + iterator.next().get();
		}
		context.write(key, new IntWritable(count));
	}
			
}
