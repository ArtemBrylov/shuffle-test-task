package com.example.serviceshuffle.controller;

import com.example.serviceshuffle.service.LogService;
import com.example.serviceshuffle.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ShuffleController {
    @Autowired
    ShuffleService shuffleService;

    @Autowired
    LogService logService;

    @PostMapping("/shuffle")
    public ResponseEntity<List<Integer>> shuffle(@RequestParam int number) {

        if (number < 1 || number > 1000) {
            throw new IllegalArgumentException("Invalid number. Number must be between 1 and 1000.");
        }

        var resultNumbers = shuffleService.shuffle(number);
        logService.sendLog("Result of shuffle service: " + resultNumbers);

        return ResponseEntity.ok(resultNumbers);
    }
}
