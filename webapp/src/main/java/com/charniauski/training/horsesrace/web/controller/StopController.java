package com.charniauski.training.horsesrace.web.controller;


import com.charniauski.training.horsesrace.services.cacherequest.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by ivc4 on 25.11.2016.
 */
@RestController
@RequestMapping("/stopserver")
public class StopController{
    private static final Logger LOGGER = LoggerFactory.getLogger(StopController.class);
    @Inject
    private Cacheable cacheable;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public void stopServer() throws IOException {
        cacheable.serialize("D://server_cache/cache.dat");
        LOGGER.info("Stop caching request");
        LOGGER.info("Server shutdown");
        System.exit(0);
    }
}
