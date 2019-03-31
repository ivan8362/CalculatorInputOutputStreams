package com.lavrovivan;

import java.io.*;

public class Calculator {

    void calculate(File file) {
        BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = null;
        String firstArg = "";
        String secondArg = "";
        String operator = "";
        String log = "";
        double result = 0;


        try {
            fileWriter = new FileWriter(file, true);

            System.out.println("type the first argument + enter");
            firstArg = bufferedR.readLine();

            System.out.println("type operator (+ - * / pow sqrt) + enter");
            operator = bufferedR.readLine();

            System.out.println("type the second argument + enter");
            secondArg = bufferedR.readLine();
            switch (operator) {
                case "+":
                    result = Integer.valueOf(firstArg) + Integer.valueOf(secondArg);
                    log = firstArg + " + " + secondArg + " = " + result;
                    System.out.println(log);
                    break;
                case "-":
                    result = Integer.valueOf(firstArg) - Integer.valueOf(secondArg);
                    log = firstArg + " - " + secondArg + " = " + result;
                    System.out.println(log);
                    break;
                case "*":
                    result = Integer.valueOf(firstArg) * Integer.valueOf(secondArg);
                    log = firstArg + " * " + secondArg + " = " + result;
                    System.out.println(log);
                    break;
                case "/":
                    result = Integer.valueOf(firstArg) / Integer.valueOf(secondArg);
                    log = firstArg + " / " + secondArg + " = " + result;
                    System.out.println(log);
                    break;
                case "pow":
                    result = Math.pow(Double.valueOf(firstArg), Double.valueOf(secondArg));
                    log = firstArg + " raised to the power of " + secondArg + " = " + result;
                    System.out.println(log);
                    break;
                case "sqrt":
                    result = Math.sqrt(Double.valueOf(firstArg));
                    log = "square root of " + firstArg +  " = " + result;
                    System.out.println(log);
                    break;
                default:
                    System.out.println("Error. operator can be (+ - * / pow sqrt)");
            }
            log += "\r\n";
            fileWriter.append(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the file
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void showLog(File file) {
        int i;
        FileInputStream fin = null;

        // The following code opens a file, reads characters until EOF
        // is encountered, and then closes the file via a finally block.
        try {
            fin = new FileInputStream(file);

            do {
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            } while(i != -1);

        } catch(FileNotFoundException exc) {
            System.out.println("File Not Found.");
        } catch(IOException exc) {
            System.out.println("An I/O Error Occurred");
        } finally {
            // Close file in all cases.
            try {
                if(fin != null) fin.close();
            } catch(IOException exc) {
                System.out.println("Error Closing File");
            }
        }
    }
}
