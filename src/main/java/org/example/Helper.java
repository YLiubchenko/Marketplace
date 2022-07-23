package org.example;


public class Helper {
    static StoreMenu storeMenu = new StoreMenu();
    public static String generateID () {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    public static String inputNumber(String message) {
        String answer = "";
        String msg = message;

        while (answer.isEmpty()) {
            System.out.println(msg);
            String scannerAnswer = storeMenu.getScannerValueStr();

            float priceFloat = scannerAnswer.chars().allMatch(Character::isDigit) ? Float.parseFloat(scannerAnswer) : -1;

            if (priceFloat < 0) {
                msg = "Please, enter a positive number!";
            } else {
                answer = String.valueOf(priceFloat);
            }
        }

        return answer;
    }

    static String inputAnswer(String question) {
        String answer = "";

        while (answer.isEmpty()) {
            System.out.println(question);
            answer = storeMenu.getScannerValueStr();
        }

        return answer;
    }
}
