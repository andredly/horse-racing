package com.charniauski.training.horsesrace.services.customauthorization;

import org.springframework.security.core.userdetails.UserDetails;

public class SecurityContextHolder {

    private static final ThreadLocal<UserDetails> threadLocalScope = new  ThreadLocal<>();
	
	public final static UserDetails getLoggedUserDetails() {
		return threadLocalScope.get();
	}
	
	public final static void setLoggedUserDetails(UserDetails userDetails) {
		threadLocalScope.set(userDetails);
	}

}