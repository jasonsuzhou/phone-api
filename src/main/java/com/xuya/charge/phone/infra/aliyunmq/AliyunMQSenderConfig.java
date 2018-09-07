package com.xuya.charge.phone.infra.aliyunmq;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliyunMQSenderConfig {

	@Value("${aliyun.mq.accesskey}") String accessKey;
	@Value("${aliyun.mq.secretkey}") String secretKey;
	@Value("${aliyun.mq.topic.order}") String orderTopic;
	@Value("${aliyun.mq.topic.order.pid}") String orderTopicProducer;
	@Value("${aliyun.mq.topic.callback}") String callbackTopic;
	@Value("${aliyun.mq.topic.callback.pid}") String callbackTopicProducer;

	@Bean
	public AliyunMQMsgSender orderCreatedSender() {
		if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
			AliyunMQMsgSender sender = new AliyunMQMsgSender(orderTopic);
			sender.initProducer(orderTopicProducer, accessKey, secretKey);
			return sender;
		} else {
			return new AliyunMQMsgSender();
		}
	}
	
	@Bean
	public AliyunMQMsgSender providerCallbackSender() {
		if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
			AliyunMQMsgSender sender = new AliyunMQMsgSender(callbackTopic);
			sender.initProducer(callbackTopicProducer, accessKey, secretKey);
			return sender;
		} else {
			return new AliyunMQMsgSender();
		}
	}

}
