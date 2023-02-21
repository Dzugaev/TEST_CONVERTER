package com.example.TEST_CONVERTER.service;

import org.springframework.stereotype.Service;

@Service
public interface ConverterService {

    String stringToNumber(String name);

    String numberToString(Long number);
}


