package com.charniauski.training.horsesrace.web.security;

import org.springframework.stereotype.Service;
@Service
public class InfoService implements IInfoService {
    public String getMsg() {
		return "Hello ";
	}
} 