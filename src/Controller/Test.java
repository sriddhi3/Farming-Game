package controller;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("");
        for (int i = 0; i < 30; i++) {
            System.out.println((int) Math.floor(Math.random() * 16));
        }
    }

}
