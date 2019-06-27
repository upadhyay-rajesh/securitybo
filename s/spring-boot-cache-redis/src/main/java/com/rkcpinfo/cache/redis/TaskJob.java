package com.rkcpinfo.cache.redis;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class TaskJob {
	Logger logger = LogManager.getLogger(getClass());
	@Autowired
	private CityService cityService;
	
	@Scheduled(fixedDelay = 500)
	public void retrieveCountry() {
		int index = new Random().nextInt(list.size());
		String city = find(index);
		CityInfo info = cityService.getCity(index, city);
		
		logger.info("city: {}", JSON.toJSONString(info));
	}

	private String find(int index) {
		return list.get(index);
	}

	private static final List<String> list = Arrays.asList("Delhi", "Bangalore", "Hyderabad", "Chennai");
}
