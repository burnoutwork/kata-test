package roman;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;



public class RomanNumeralsConverter {

    private final Map<String, Integer> numberByNumeral;

    public RomanNumeralsConverter() {
        Map<String, Integer> numberByNumeral = new LinkedHashMap<String, Integer>();
        numberByNumeral.put("M", 1000);
        numberByNumeral.put("CM", 900);
        numberByNumeral.put("D", 500);
        numberByNumeral.put("CD", 400);
        numberByNumeral.put("C", 100);
        numberByNumeral.put("XC", 90);
        numberByNumeral.put("L", 50);
        numberByNumeral.put("XL", 40);
        numberByNumeral.put("X", 10);
        numberByNumeral.put("IX", 9);
        numberByNumeral.put("V", 5);
        numberByNumeral.put("IV", 4);
        numberByNumeral.put("I", 1);
        this.numberByNumeral = Collections.unmodifiableMap(numberByNumeral);
    }


    public String convertIntegerToRomanNumerals(Integer arabicInteger) {
        StringBuilder romanNumeralsBuilder = new StringBuilder();
        int remainder = arabicInteger;
        for (Map.Entry<String, Integer> numeralKeyArabicValue : numberByNumeral.entrySet()) {
            while (remainder >= numeralKeyArabicValue.getValue()) {
                romanNumeralsBuilder.append(numeralKeyArabicValue.getKey());
                remainder -= numeralKeyArabicValue.getValue();
            }
        }
        return romanNumeralsBuilder.toString();
    }

    public Integer convertRomanNumeralsToInteger(String romanNumeralsString) {
        Integer total = 0;
        String lastNumeral = "";
        char[] romanNumerals = romanNumeralsString.toUpperCase().toCharArray();
        for (int i = romanNumerals.length - 1; i > -1; i--) {
            String numeral = String.valueOf(romanNumerals[i]);
            total += getIntegerValueFromAdjacentNumerals(numeral, lastNumeral);
            lastNumeral = numeral;
        }
        return total;
    }

    private Integer getIntegerValueFromAdjacentNumerals(String leftNumeral, String rightNumeral) {
        Integer leftNumeralIntegerValue = numberByNumeral.get(leftNumeral);
        Integer rightNumeralIntegerValue = "".equals(rightNumeral) ? 0 : numberByNumeral.get(rightNumeral);
        return rightNumeralIntegerValue > leftNumeralIntegerValue ?
                -1 * leftNumeralIntegerValue : leftNumeralIntegerValue;
    }

}