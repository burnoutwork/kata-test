import roman.RomanNumeralsConverter;

import java.util.Scanner;

public class Main {
    static String[] operationCharters = {"+", "-", "*", "/"};
    public static void main(String[] args) throws Exception {
        String input = readStandardInput();
        Operation operation = parseInput(input);
        int result = operation.calculate();

        if (operation.isRoman()) {
            RomanNumeralsConverter converter = new RomanNumeralsConverter();
            System.out.println(converter.convertIntegerToRomanNumerals(result));
        } else {
            System.out.println(result);
        }
    }

    static String readStandardInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        return line.replace(" ", "").trim();
    }

    static Operation parseInput(String input) throws Exception {
        String[] partsInput = {};
        OperationKind operationKind = null;

        for (String operationChart : operationCharters) {
            if (input.contains(operationChart)) {
                partsInput = input.split("\\%s".formatted(operationChart));
                operationKind = OperationKind.fromString(operationChart);
                break;
            }
        }

        if (partsInput.length != 2) {
            throw new Exception();
        }

        String firstPart = partsInput[0];
        String secondPart = partsInput[1];

        for (String operationChart: operationCharters) {
            if (secondPart.contains(operationChart)) {
                throw new Exception();
            }
        }

        int firstNumber, secondNumber;
        boolean isRoman;

        try {
            firstNumber = Integer.parseInt(firstPart);
            secondNumber = Integer.parseInt(secondPart);
            isRoman = false;
        } catch (Exception e) {
            RomanNumeralsConverter converter = new RomanNumeralsConverter();

            firstNumber = converter.convertRomanNumeralsToInteger(firstPart);
            secondNumber = converter.convertRomanNumeralsToInteger(secondPart);
            isRoman = true;
        }

        if (firstNumber > 10 || firstNumber < 1 || secondNumber >  10 || secondNumber < 1) {
            throw new Exception();
        }

        return new Operation(isRoman, operationKind, firstNumber, secondNumber);
    }

}