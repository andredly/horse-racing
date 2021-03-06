package com.charniauski.training.horsesrace.web.security;

import org.springframework.security.core.userdetails.UserDetails;

public class CustomSecurityContextHolder {

    private static final ThreadLocal<UserDetails> threadLocalScope = new  ThreadLocal<>();
	
	public static UserDetails getLoggedUserDetails() {
		return threadLocalScope.get();
	}
	
	public static void setLoggedUserDetails(UserDetails userDetails) {
		threadLocalScope.set(userDetails);
	}

	public static void removeLoggedUserDetails() {
		threadLocalScope.remove();
	}

}