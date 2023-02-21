package com.example.TEST_CONVERTER.service;

import com.example.TEST_CONVERTER.postgres.Entity.LogInfo;
import com.example.TEST_CONVERTER.postgres.Repository.LogInfoRepository;
import com.example.TEST_CONVERTER.postgres.Repository.NumbersDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements ConverterService {

    private final LogInfoRepository logInfoRepository;

    private final NumbersDataRepository numbersDataRepository;



    @Override
    public String stringToNumber(String name) {
        return processString(name);
    }

    @Override
    public String numberToString(Long number) {
        return processNumber(number);
    }

    private String processString(String name) {
        Long sum = 0L;
        Long finalSum = 0L;
        ArrayList<String> words = new ArrayList<>(Arrays.asList(name.split(" ")));
        boolean minus = false;


        for (String word : words) {
            minus = word.equals("minus");

            if ((word.equals("hundred")) || (word.equals("thousand")) ||
                    (word.equals("million")) || (word.equals("billion"))) {
                try {
                    finalSum += sum * numbersDataRepository.findByName(word).getNumber();
                    sum=0L;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return ("Возможна ошибка в написании цифры");
                }
            } else {
                try {
                    sum += numbersDataRepository.findByName(word).getNumber();
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return ("Возможна ошибка в написании цифры");
                }
            }
        }
        finalSum += sum;
        if (minus) finalSum *= -1;
        return finalSum.toString();
    }

    private String processNumber(Long number) {
        String output = "";
        Long forLog = number;
        if (number < 0) {
            output += "minus ";
            number *= (-1);
        }

        if (((number / 100000) / 10000000) > 0) return "Nuber is out of bounds";

        while (number > 0) {
            if (number < 21) {
                output += numbersDataRepository.findByNumber(number).getName();
                break;
            }
            if ((number > 20) && (number < 1000)) {     /** меньше тысячи */
                output += getHundreds(number.intValue());
                number = -1L;
            }

            if ((number > 999) && (number < 1000000)) {       /** от тысячи до 999 тысяч  */
                output += getThousands(number.intValue());
                number = number % 1000;
            }

            if ((number > 999999) && (number < 1000000000)) { /** от миллиона до 999 миллионов  */
                output += getMillions(number);
                number = number % 1000000;
            }

            if (number > 999999999) {    /** от миллиарда */
                output += getBillions(number);
                number = number % 1000000000;
            }
        }
        return output;
    }

    private String getBillions(long n) {
        String output = "";
        output += getHundreds((int) (n / 1000000000)) + "billion ";
        return output;
    }

    private String getMillions(long n) {
        String output = "";
        output += getHundreds((int) (n / 1000000)) + "million ";
        return output;
    }

    private String getThousands(int n) {
        String output = "";
        output += getHundreds((n / 1000)) + "thousand ";
        return output;
    }


    private String getHundreds(Integer inputNumber)  {
        String output = "";
        Integer digit = inputNumber / 100;
        // if (digit > 0) output += numbersDataRepository.findByNumber(digit.toString()).getName() + " hundred ";

        try {

            output = (digit > 0) ? output + numbersDataRepository.findByNumber(digit.longValue()).getName() + " hundred " : output;

            digit = inputNumber % 100;
            if (digit == 0) return output; /** если остаток равен нулю -> выход*/

            if (digit < 21) {
                output += numbersDataRepository.findByNumber(digit.longValue()).getName() + " ";
            } else {
                Integer tmpDigit = (digit / 10) * 10;
                output += numbersDataRepository.findByNumber(tmpDigit.longValue()).getName() + " ";
                tmpDigit = digit % 10;
                if (tmpDigit == 0) return output;                 /** если остаток равен нулю -> выход*/
                else output += numbersDataRepository.findByNumber(tmpDigit.longValue()).getName() + " ";
            }
        }
        catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
        return output;
    }
}

