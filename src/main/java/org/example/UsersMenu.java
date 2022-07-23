package org.example;

import java.util.Scanner;

public class Users {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] menu = {1, 2, 3};
        int result = 0;
        int close = 3;

        for (int item : menu) {
            System.out.println(item);
        }

        while (result != close) {

            System.out.println("Enter number");
            result = scanner.nextInt();

            switch (result) {
                case 1:
                    break;
                case 2:
                    break;

            }


        }

        scanner.close();
    }
}