package com.test.java.chap01;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            System.out.println((char)scanner.nextInt());
        }
    }
}
