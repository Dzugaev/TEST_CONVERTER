//package com.example.TEST_CONVERTER.controller;
//
//import com.example.TEST_CONVERTER.service.ConverterService;
//import io.swagger.annotations.*;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
////@Api(tags = SwaggerConfig.TAG)
//public class SwaggerConvertController {
//
//    private final ConverterService converterService;
//
//    @ApiOperation(value = "Конвертация строки в число")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "ОК"),
//            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
//    })
//    @ApiImplicitParam(name = "type", value = "type", dataType = "String", required = true, allowableValues = "StringToNumber, NumberToString")
//    @GetMapping(value = "/converter")
//    public ResponseEntity<String> converter(
//            @RequestParam(value = "number", required = true, defaultValue = "12") final String number,
//            @RequestParam(value = "type", required = true,  defaultValue = "NumberToString") final String type
//    ){
//        String output = "";
//        Long longNumber;
//
//        switch (type.toLowerCase()) {
//            case "numbertostring":
//                try {
//                    longNumber = Long.parseLong(number);
//                }
//                catch (Exception e){
//                    log.error(e.getMessage());
//                    return new ResponseEntity<>("Ошибка в написании цифры", HttpStatus.BAD_REQUEST);
//                }
//                output = converterService.numberToString(longNumber);
//                break;
//            case "stringtonumber":
//                output = converterService.stringToNumber(number);
//                try {
//                    longNumber = Long.parseLong(output);
//                }
//                catch (Exception e){
//                    log.error(e.getMessage());
//                    return new ResponseEntity<>("Ошибка в написании цифры", HttpStatus.BAD_REQUEST);
//                }
//                break;
//        }
//        return new ResponseEntity<>(output, HttpStatus.OK);
//    }
//}
