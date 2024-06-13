package com.example.servicelog.controller;

import com.example.servicelog.model.LogMessage;
import com.example.servicelog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LogController {
    @Autowired
    LogService logService;

    @PostMapping("/log")
    public ResponseEntity<String> shuffle(@RequestBody LogMessage logMessage) {
        logService.log(logMessage.getMessage());

        return ResponseEntity.ok("Message logged successfully!");
    }
}
