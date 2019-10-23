package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("Welcome to my 2048 game!");
        System.out.println("Move using by typing w, a, s, d");
        System.out.println("Have fun!");
        System.out.println();

        while(true) {
            char move;
            board.show();
            try {
                board.move();
            }
            catch(StackOverflowError stackOverflowError) {
                System.out.println("You're out of moves!");
            }
        }
    }
}
