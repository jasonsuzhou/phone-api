package com.xuya.charge.phone.infra.aliyunmq;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;

public class AliyunMQMsgSender {
	private static final int RETRY_TIMES = 3;
	private static final int TIMEOUT = 10000;

	private Producer producer;
	private String topicName;

	public AliyunMQMsgSender() {}
	
	public AliyunMQMsgSender(String topicName) {
		this.topicName = topicName;
	}

	public SendResult sendMessage(String message) throws Exception {
		byte[] content = message.getBytes("utf-8");
		Message msg = new Message(topicName, "", content);
		SendResult result = null;
		try {
			result = producer.send(msg);
		} catch (Throwable e) {
			result = retrySendMessage(msg, RETRY_TIMES);
		}
		return result;
	}

	public SendResult sendMessage(String message, String msgKey) throws Exception {
		byte[] content = message.getBytes("utf-8");
		Message msg = new Message(topicName, "", msgKey, content);
		SendResult result = null;
		try {
			result = producer.send(msg);
		} catch (Throwable e) {
			result = retrySendMessage(msg, RETRY_TIMES);
		}
		return result;
	}

	/**
	 * 延迟发布消息
	 * 
	 * @param message
	 * @param tag
	 * @param delaySecond
	 *            延时时间 单位为秒
	 * @return
	 * @throws Exception
	 */
	public SendResult sendMessage(String message, String tag, int delaySecond) throws Exception {
		byte[] content = message.getBytes("utf-8");
		Message msg = new Message(topicName, tag, content);
		msg.setStartDeliverTime(System.currentTimeMillis() + (delaySecond * 1000));
		SendResult result = null;
		try {
			result = producer.send(msg);
		} catch (Throwable e) {
			result = retrySendMessage(msg, RETRY_TIMES);
		}
		return result;
	}

	private SendResult retrySendMessage(Message message, int retryTimes) {
		for (int i = 0; i < retryTimes; i++) {
			try {
				return producer.send(message);
			} catch (Throwable e) {
				// do nothing
			}
		}
		return null;
	}

	public void shutdown() {
		if (producer != null && producer.isStarted()) {
			producer.shutdown();
		}
	}

	public void initProducer(String pid, String accessKey, String secretKey) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ProducerId, pid);
		properties.put(PropertyKeyConst.AccessKey, accessKey);
		properties.put(PropertyKeyConst.SecretKey, secretKey);
		properties.put(PropertyKeyConst.SendMsgTimeoutMillis, TIMEOUT);
		producer = ONSFactory.createProducer(properties);
		producer.start();
	}

}
