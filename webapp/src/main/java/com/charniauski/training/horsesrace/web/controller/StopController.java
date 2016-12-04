package com.charniauski.training.horsesrace.web.controller;

import com.charniauski.training.horsesrace.services.cacherequest.SimpleCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Inject
    private SimpleCache cache;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public void stopServer() throws IOException {
        cache.serialize("D://server_cache/cache.dat");
        System.exit(0);
    }
}
