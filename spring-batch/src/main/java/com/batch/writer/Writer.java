package com.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> arg0) throws Exception {
		for(String msg:arg0){
			System.out.println("Writing the data "+msg);
		}

	}

}
