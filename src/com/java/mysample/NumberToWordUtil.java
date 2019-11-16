package com.java.mysample;

public class NumberToWordUtil {
	
    public String convert(int number) {

        if (number == Constants.NUMBER_ZERO) { return Constants.ZERO; }
        
        String prefix = Constants.EMPTY_STRING;
        
        if (number < Constants.NUMBER_ZERO) {
            number = -number;
            prefix = "negative";
        }
        
        String current = Constants.EMPTY_STRING;
        int place = Constants.NUMBER_ZERO;
        
        do {
            int n = number % Constants.NUMBER_THOUSAND;
            if (n != Constants.NUMBER_ZERO){
                String s = convertLessThanOneThousand(n);
                current = s + Constants.specialNames[place] + current;
            }
            place++;
            number /= Constants.NUMBER_THOUSAND;
        } while (number > Constants.NUMBER_ZERO);
        
        return (prefix + current).trim();
    }
    
    private String convertLessThanOneThousand(int number) {
        String current;
        
        if (number % Constants.HUNDRED < Constants.NUMBER_TWENTY){
            current = Constants.numNames[number % Constants.HUNDRED];
            number /= Constants.HUNDRED;
        }
        else {
            current =Constants.numNames[number % Constants.NUMBER_TEN];
            number /= Constants.NUMBER_TEN;
            
            current = Constants.tensNames[number % Constants.NUMBER_TEN] + current;
            number /= Constants.NUMBER_TEN;
        }
        if (number == Constants.NUMBER_ZERO) return current;
        return Constants.numNames[number] + " hundred and" + current;
    }
    
    


}
