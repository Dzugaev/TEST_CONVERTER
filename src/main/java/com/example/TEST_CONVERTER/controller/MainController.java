package com.example.TEST_CONVERTER.controller;

import com.example.TEST_CONVERTER.postgres.Entity.LogInfo;
import com.example.TEST_CONVERTER.postgres.Entity.User;
import com.example.TEST_CONVERTER.postgres.Repository.LogInfoRepository;
import com.example.TEST_CONVERTER.service.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.OffsetDateTime;
import java.util.Map;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private LogInfoRepository logInfoRepository;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {
        return "greeting";

    }

    @GetMapping("/converter")
    public String main(Model model){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);

        return "converter";
    }

    @PostMapping(value = "/converter")
    public String converter(
            @RequestParam String number,
            @RequestParam String type,
            Model model
    ){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", currentUser);

        String output = "";
        //Long longNumber;

        try {
            if (type.toLowerCase().equals("numbertostring")) {
                output = converterService.numberToString(Long.parseLong(number));
            } else {
                output = converterService.stringToNumber(number);
            }

        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            logInfoRepository.save(LogInfo.builder()
                            .input(number)
                            .output("Input data are incorrect")
                            .userId(currentUser.getId())
                            .type("ERROR")
                            .created(OffsetDateTime.now())
                    .build());
            model.addAttribute("error", "Input data are incorrect");
            return "converter";
        }

        logInfoRepository.save(LogInfo.builder()
                .input(number)
                .output(output)
                .userId(currentUser.getId())
                .type(type)
                .created(OffsetDateTime.now())
                .build());
        model.addAttribute("output", output);
        return "converter";
    }
}