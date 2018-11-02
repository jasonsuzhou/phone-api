package com.xuya.charge.phone.infra.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class IdWorker {

	private static long lastTimes = 0;
	private static AtomicInteger currentSequence = new AtomicInteger(100);

	public synchronized static String nextId(String prefix) {
		StringBuffer sb = new StringBuffer(prefix);
		long currentTimes = System.currentTimeMillis();
		if (lastTimes == currentTimes) {
			int result = currentSequence.incrementAndGet();
			if (result > 999) {
				currentTimes = genTimes(lastTimes);
			}
			sb.append(getTimeString(currentTimes)).append(result);
		} else {
			lastTimes = currentTimes;
			currentSequence = new AtomicInteger(100);
			sb.append(getTimeString(currentTimes)).append(currentSequence);
		}
		return sb.toString();
	}

	private static long genTimes(long lastTimes) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// do nothing
		}
		long times = System.currentTimeMillis();
		if (times == lastTimes) {
			return genTimes(lastTimes);
		}
		return times;
	}

	private static String getTimeString(long currentTimes) {
		Date date = new Date(currentTimes);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		return sdf.format(date);
	}

}
