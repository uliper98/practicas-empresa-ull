package com.kaizten.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
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
	//public class BlueTask implements ApplicationRunner {
		
		@BeforeTask
		public void beforeTask(TaskExecution taskExecution) {
			System.out.println("Before Executing Blue Task!");
			taskExecution.setArguments(new ArrayList<>(Arrays.asList("arg1", "arg2")));
			System.out.println(taskExecution.getArguments());
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
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(arguments);
			System.out.println("Executing Blue Task:");
			if (arguments != null) {
				System.out.println("Blue parameter length: " + arguments.length);
			}
			//System.out.println(arguments);
			for (int i = 0; i < arguments.length; i++) {
				System.out.println("Blue Arg " + i + " : " + arguments[i]);
			}
			//
			System.out.println("# NonOptionArgs: " + applicationArguments.getNonOptionArgs().size());
	        System.out.println("NonOptionArgs:");
	        applicationArguments.getNonOptionArgs().forEach(System.out::println);
	
	        System.out.println("# OptionArgs: " + applicationArguments.getOptionNames().size());
	        System.out.println("OptionArgs:");
	        applicationArguments.getOptionNames().forEach(optionName -> {
	            System.out.println(optionName + "=" + applicationArguments.getOptionValues(optionName));
	        });
		}
	
		/*@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println("# NonOptionArgs: " + args.getNonOptionArgs().size());
	
	        System.out.println("NonOptionArgs:");
	        args.getNonOptionArgs().forEach(System.out::println);
	
	        System.out.println("# OptionArgs: " + args.getOptionNames().size());
	        System.out.println("OptionArgs:");
	
	        args.getOptionNames().forEach(optionName -> {
	            System.out.println(optionName + "=" + args.getOptionValues(optionName));
	        });
		}*/
	}
}

