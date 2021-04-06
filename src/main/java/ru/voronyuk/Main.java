package ru.voronyuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static CalculateManager calculateManager = new CalculateManager();
    public static void main(String[] args) throws Exception {
//        String function1 = "2*1";
//        String function2 = "II*III";
//        String function3 = "2*III";
//        calculateManager.calculate(function1);
//        calculateManager.calculate(function2);
//        calculateManager.calculate(function3);

//        System.out.println(calculateManager.getFormat("xss"));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
            String string = reader.readLine();
            calculateManager.calculate(string);
        }catch (IOException e){

        }

    }
}
