package com.xuya.charge.phone.infra.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdWorker {

	private static long lastTimes = 0;
	private static int currentSequence = 100;

	public static synchronized String nextId(String prefix) {
		StringBuffer sb = new StringBuffer(prefix);
		long currentTimes = System.currentTimeMillis();
		if (lastTimes == currentTimes) {
			++currentSequence;
			if (currentSequence > 999) {
				currentTimes = genTimes(lastTimes);
			}
		} else {
			lastTimes = currentTimes;
			currentSequence = 100;
		}
		sb.append(getTimeString(currentTimes)).append(currentSequence);
		return sb.toString();
	}

	private static long genTimes(long lastTimes) {
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
