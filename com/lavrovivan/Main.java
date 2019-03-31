package com.lavrovivan;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + File.separator + "calculatorLog.txt");
        Calculator calculator = new Calculator();

        // test calculator
        calculator.calculate(file);

        // test show log file in console
//        calculator.showLog(file);
    }
}
