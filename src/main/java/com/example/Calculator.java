package com.example;


public class Calculator {


    static int add(String numbers) {
        int result = 0;
        String[] parts;
        if (numbers.isEmpty())
            return result;
        String delimiter = ",";

        parts = numbers.split("[\n]+");


        if (numbers.startsWith("//")) {
            delimiter = "";
            parts[0]=parts[0].substring(3);
            String [] subParts = parts[0].split("[]\\[]+");
            for (String subPart : subParts){
                delimiter= delimiter+"|"+subPart;
            }//split delimiter into parts. String concatenation. "+var1+"
            // "[0-9]{" + minValue + "," + maxValue + "}"

            delimiter = "["+delimiter.substring(1)+"]+";

            parts = shift(parts);
        }

        for (String part : parts) {
            try {
                String[] subParts = part.split(delimiter);
                for (String subPart : subParts) {
                    int i = Integer.parseInt(subPart);
                    if (i<0){
                        throw new IllegalArgumentException("Negatives not allowed "+ i);
                    }
                    if (i<1001)result = result + Integer.parseInt(subPart);

                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return result;
    }

    private static String[] shift(String[] array) {
        String[] result = new String[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            result[i - 1] = array[i];
        }
        return result;
    }
}
