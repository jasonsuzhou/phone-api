package com.xuya.charge.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xuya.charge.phone.intf.listener.ApplicationStartupListener;

@SpringBootApplication
public class PhoneApiApplication {

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(PhoneApiApplication.class);
		sa.addListeners(new ApplicationStartupListener());
		sa.run(args);
	}
}
