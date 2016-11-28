package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.web.security.IInfoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping
public class InfoController {
    @Inject
	private IInfoService service;
	@RequestMapping("/info")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
                     msg+=service.getMsg()+ authentication.getName()+", You have "+ role;
		}
		return msg;
	}
}