package com.example.serviceshuffle.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ShuffleService {

    public List<Integer> shuffle(int number) {
        var list = IntStream.rangeClosed(1, number)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(list);
        return list;
    }
}
