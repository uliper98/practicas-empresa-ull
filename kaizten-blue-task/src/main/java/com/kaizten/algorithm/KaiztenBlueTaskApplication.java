package com.kaizten.algorithm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class KaiztenBlueTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaiztenBlueTaskApplication.class, args);
	}
	
	@Bean
	public BlueTask BlueServiceTask() {
		return new BlueTask();
	}
	
	public class BlueTask implements CommandLineRunner {
		
		@BeforeTask
		public void beforeTask(TaskExecution taskExecution) {
			System.out.println("Before Executing Blue Task!");
		}
		
		@AfterTask
		public void afterTask(TaskExecution taskExecution) {
			System.out.println("After Executing Blue Task!");
			taskExecution.setExitMessage("Everything was fine!");
		}
		
		@FailedTask
		public void failedTask(TaskExecution taskExecution, Throwable throwable) {
			System.out.println("Executing Blue Task has Failed!");
		}
		
		@Override
		public void run(String... arguments) throws Exception {
			System.out.println("Executing Blue Task:");
			if (arguments != null) {
				System.out.println("Blue parameter length: " + arguments.length);
			}
			for (int i = 0; i < arguments.length; i++) {
				System.out.println("Blue Arg " + i + " : " + arguments[i]);
			}		
		}
	}
}

