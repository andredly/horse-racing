package com.charniauski.training.horsesrace.web.filter;

import com.charniauski.training.horsesrace.services.CustomAuthenticationService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Enumeration;

public class BasicAuthFilter implements Filter {
    private CustomAuthenticationService customAuthenticationService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        customAuthenticationService = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext()).getBean(
                CustomAuthenticationService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;

        String[] credentials = resolveCredentials(req);

        boolean isCredentialsResolved = credentials != null && credentials.length == 2;
        if (!isCredentialsResolved) {
            res.sendError(401);
            return;
        }

        String username = credentials[0];
        String password = credentials[1];
        if (customAuthenticationService.validateUserPassword(username, password)) {
            chain.doFilter(request, response);
        } else {
            res.sendError(401);
        }

    }

    private String[] resolveCredentials(HttpServletRequest req) {
        try {
            Enumeration<String> headers = req.getHeaders("Authorization");
            String nextElement = headers.nextElement();
            String base64Credentials = nextElement.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
            return credentials.split(":", 2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroy() {
    }

}