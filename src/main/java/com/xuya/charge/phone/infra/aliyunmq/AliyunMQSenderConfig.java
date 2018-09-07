package com.xuya.charge.phone.infra.aliyunmq;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliyunMQSenderConfig {

	@Value("${aliyun.mq.accesskey}")
	private String accessKey;
	@Value("${aliyun.mq.secretkey}")
	private String secretKey;

	@Bean
	@Qualifier("orderSender")
	public AliyunMQMsgSender orderSender() {
		if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
			AliyunMQMsgSender sender = new AliyunMQMsgSender("FLUX_CALLBACK");
			sender.initProducer("PID_FLUX_CALLBACK", accessKey, secretKey);
			return sender;
		} else {
			return new AliyunMQMsgSender();
		}
	}
	
	@Bean
	@Qualifier("providerCallbackSender")
	public AliyunMQMsgSender providerCallbackSender() {
		if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
			AliyunMQMsgSender sender = new AliyunMQMsgSender("FLUX_CALLBACK");
			sender.initProducer("PID_FLUX_CALLBACK", accessKey, secretKey);
			return sender;
		} else {
			return new AliyunMQMsgSender();
		}
	}

}
