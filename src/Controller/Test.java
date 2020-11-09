package Controller;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0; i < 10; i++){
//            System.out.println((int) Math.ceil(Math.random() * 3));
        }
        System.out.println("");
        for(int i = 0; i < 30; i++){
            System.out.println((int) Math.floor(Math.random() * 16));
        }
    }

}
