package com.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletinListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus()==BatchStatus.COMPLETED){
			System.out.println("job have completed");
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job is start");
	}

}
