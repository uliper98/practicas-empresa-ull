package com.kaizten.algorithm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class KaiztenRedTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaiztenRedTaskApplication.class, args);
	}
	
	@Bean
	public BlueTask RedServiceTask(){
		return new BlueTask();
	}
	
	public class BlueTask implements CommandLineRunner {
		
		@Override
		public void run(String...strings) throws Exception {
			System.out.println("EXECUTING RED TASK!");
			if (null != strings) {
				System.out.println("Red parameter length: " + strings.length);
			}
			for (int i=0;i<strings.length;++i) {
				System.out.println("Red Arg " + i + " : "+strings[i]);
			}		
		}
	}
}

