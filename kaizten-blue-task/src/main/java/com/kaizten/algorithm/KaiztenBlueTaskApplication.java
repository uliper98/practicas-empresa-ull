package com.kaizten.algorithm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class KaiztenBlueTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaiztenBlueTaskApplication.class, args);
	}
	
	@Bean
	public BlueTask RedServiceTask(){
		return new BlueTask();
	}
	
	public class BlueTask implements CommandLineRunner {
		
		@Override
		public void run(String... strings) throws Exception {
			System.out.println("EXECUTING BLUE TASK!");
			if (null != strings) {
				System.out.println("Blue parameter length: " + strings.length);
			}
			for (int i = 0; i < strings.length; i++) {
				System.out.println("Blue Arg " + i + " : " + strings[i]);
			}		
		}
	}
}

