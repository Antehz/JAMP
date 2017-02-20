package com.epam.module1.core.spring.loggers;

import java.util.ArrayList;
import java.util.List;

import com.epam.module1.core.spring.beans.Review;

//DRY, remove code duplication
public class CacheFileEventLogger extends FileEventLogger {

	private int cacheSize;
	private List<Review> cache;
	
	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		cache=new ArrayList<Review>();
		this.cacheSize=cacheSize;
	}

	@Override
	public void logEvent(Review review) {
		cache.add(review);
		if (cacheSize==cache.size()){
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
		for (Review review : cache) {
			super.logEvent(review);
		}
		
	}
	private void destroy(){
		if(!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
}
