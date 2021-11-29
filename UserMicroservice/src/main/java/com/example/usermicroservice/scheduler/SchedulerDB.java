package com.example.usermicroservice.scheduler;

import com.example.usermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerDB {
	private final OrderService orderService;

	@Scheduled(cron = "0 0 1 * * ?")
	public void refreshDB() {
		orderService.refreshCache();
	}
}
