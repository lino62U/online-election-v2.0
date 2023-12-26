package com.microservice.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gateway")
public class GatewayController {
    @GetMapping(value = "all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok("DESDE GATEWAY");
    }
}
