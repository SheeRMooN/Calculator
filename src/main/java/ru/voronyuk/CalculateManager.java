package ru.voronyuk;

import ru.voronyuk.model.DateEnter;
import ru.voronyuk.model.ValueFormat;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculateManager {
    private Integer[] arabic = {1,2,3,4,5,6,7,8,9,10};
    private String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private DateEnter date;
    private final int ARRAY_LENGTH = 10;


    public void calculate(String function) throws Exception {
        date = creteDateCalculate(function);
        int count = getCountArithmetic(date);
        if (date.getFormat().equals(ValueFormat.ARABIC)){
            System.out.println(count);
        }else {
            System.out.println(getRomeNumber(count));
        }
    }

    private static String getRomeNumber(int number){
        if(number<=0){
            return "0";
        }
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        String romanEqui="";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            if(number/key!=0){
                for (int i = 0; i < (number/key); i++) {
                    romanEqui = romanEqui + map.get(key);
                }
                number = number % key;
            }
        }
        return romanEqui;
    }

    private int getCountArithmetic(DateEnter date) {
        int value = 0;
        int one = date.getNumberOne();
        int two = date.getNumberTwo();
        switch (date.getOperation()){
            case "*":
                value = one*two;
                break;
            case "/":
                value = one/two;
                break;
            case "+":
                value = one+two;
                break;
            case "-":
                value = one-two;
                break;
        }
        return value;
    }


     ValueFormat getFormat(String str){
        ValueFormat number = null;
        try {
            if (Integer.valueOf(str) != null){
                number = ValueFormat.ARABIC;
                return number;
            }
        }catch (Exception e){
        }
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (str.equals(roman[i])){
                number = ValueFormat.ROMAN;
                return number;
            }
        }
        return number;
    }

    private DateEnter creteDateCalculate(String function) throws Exception {
        ValueFormat format = ValueFormat.ARABIC;
        String operation = getOperation(function);
        String oneVal = function.substring(0,function.indexOf(operation));
        String twoVal = function.substring(function.indexOf(operation)+1,function.length());
        if (getFormat(oneVal).equals(getFormat(twoVal))){
            format = getFormat(oneVal);
        }else {
            throw new ArithmeticException();
        }
        int valueOne = getNumber(oneVal);
        int valueTwo = getNumber(twoVal);
        return new DateEnter(
                valueOne,
                valueTwo,
                operation,
                format
        );
    }

    private int getNumber(String substring) {
        int number = 0;
        try {
            number = Integer.valueOf(substring);
            return number;
        }catch (Exception e){
            // Исправить эксепшн на правильный
        }
        for (int i = 0; i < 10; i++) {
            if (substring.equals(roman[i])){
                number = i+1;
                return number;
            }
        }
        return number;
    }

    private String getOperation(String str){
        String operation = "";
        if (str.contains("+")){
            operation = "+";
        }else if (str.contains("-")){
            operation = "-";
        }else if (str.contains("*")){
            operation = "*";
        }else if (str.contains("/")){
            operation = "/";
        }else {
            throw new ArithmeticException();
        }
        return operation;
    }
}
