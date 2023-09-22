package com.ventech.batch.main.config;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

	@Scheduled(fixedDelay = 5000, initialDelay = 5000)
	public void scheduleByFixedRate() throws Exception {
		
//		File path = new File("src/main/resources/data.txt");
//		FileWriter wr = new FileWriter(path);
//		
//		Date date = Calendar.getInstance().getTime();  
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
//        String strDate = dateFormat.format(date);  
//		
//		
//        wr.write(strDate);
//        wr.flush();
//        wr.close();
//		
		
		System.out.println("Batch job starting");
		
		
		
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("time", format.format(Calendar.getInstance().getTime())).toJobParameters();
		jobLauncher.run(job, jobParameters);
		
		
		System.out.println("Batch job executed successfully\n");
	}
}