package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String arg0) throws Exception {
		return arg0.toUpperCase();
	}

}
