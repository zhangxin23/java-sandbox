package com.programming.challenges.vol1;

import java.util.Scanner;

public class Problem1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            System.out.println((char)scanner.nextInt());
        }
    }
}
