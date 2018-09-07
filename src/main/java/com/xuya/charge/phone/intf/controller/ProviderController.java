package com.xuya.charge.phone.intf.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.xuya.charge.phone.application.service.ProviderApplicationService;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.intf.dto.ProviderCallbackCommand;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {
	
	@Autowired
	private ProviderApplicationService providerApplicationServiceImpl;
	
	@GetMapping("/order/back/{channelId}")
	@PostMapping("/order/back/{channelId}")
	public String updateOrderResult(@PathVariable("channelId") String channelId, HttpServletRequest request, HttpServletResponse reponse) {
		String headString = request.getQueryString();
		String bodyString = null;
		try {
			InputStream is = request.getInputStream();
			if (is != null) {
				bodyString = CharStreams.toString(new InputStreamReader(is, Charsets.UTF_8));
			}
		} catch (IOException e) {
			throw new RestfulRequestException(ReturnCode.SYSTEM_ERROR, "read request error");
		}
		ProviderCallbackCommand command = new ProviderCallbackCommand(channelId, headString, bodyString);
		providerApplicationServiceImpl.updateOrderResult(command);
		return "ok";
	}

}
