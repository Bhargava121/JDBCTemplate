package com.example.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.DAO.UserDAOImpl;

@Component
public class Scheduler {
	@Value("${cron.user}")
	private String cron;
	
	@Autowired
	private UserDAOImpl dao;
	
	@Scheduled(fixedRate = 5000)
	public void task() {
		System.out.println("Running task"+ (dao.getUserById(1)).toString());
		
		//dao.getUserById(1);
	}

}