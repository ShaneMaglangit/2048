package com.company;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private int[][] board;

    public Board() {
        board = new int[4][4];
        generateBox();
    }

    public void show() {
        for(int[] row : board) {
            for(int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }
    }

    public void move() {
        Scanner sc = new Scanner(System.in);
        char move;

        System.out.print("Move: ");
        move = sc.nextLine().charAt(0);

        for(int x = 0; x < 4; x++) {
            switch (move) {
                case 'a':
                    for(int row = 0; row <= 3; row++) {
                        for(int col = 0; col < 3; col++) {
                            for(int i = col; i >= 0; i--) {
                                if(board[row][i] == board[row][i + 1]) {
                                    board[row][i] *= 2;
                                    board[row][i + 1] = 0;
                                }
                                else if(board[row][i] == 0 && board[row][i + 1] != 0) {
                                    board[row][i] = board[row][i + 1];
                                    board[row][i + 1] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 'd':
                    for (int row = 0; row <= 3; row++) {
                        for (int col = 3; col > 0; col--) {
                            for(int i = col; i <= 3; i++) {
                                if(board[row][i] == board[row][i - 1]) {
                                    board[row][i] *= 2;
                                    board[row][i - 1] = 0;
                                }
                                else if(board[row][i] == 0 && board[row][i - 1] != 0) {
                                    board[row][i] = board[row][i - 1];
                                    board[row][i - 1] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 'w':
                    for (int col = 0; col <= 3; col++) {
                        for (int row = 0; row < 3; row++) {
                            for(int i = row; i >= 0; i--) {
                                if (board[i][col] == board[i + 1][col]) {
                                    board[i][col] *= 2;
                                    board[i + 1][col] = 0;
                                }
                                else if (board[i][col] == 0 && board[i + 1][col] != 0) {
                                    board[i][col] = board[i + 1][col];
                                    board[i + 1][col] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 's':
                    for (int col = 0; col <= 3; col++) {
                        for (int row = 3; row > 0; row--) {
                            for(int i = row; i <= 3; i++) {
                                if (board[i][col] == board[i - 1][col]) {
                                    board[i][col] *= 2;
                                    board[i - 1][col] = 0;
                                }
                                else if (board[i][col] == 0 && board[i - 1][col] != 0) {
                                    board[i][col] = board[i - 1][col];
                                    board[i - 1][col] = 0;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input:");
                    return;
            }
        }
        generateBox();
    }

    private void generateBox() {
        Random rand = new Random();
        int x = rand.nextInt(4);
        int y = rand.nextInt(4);
        if(board[x][y] == 0) {
            board[x][y] = 2;
        }
        else {
            generateBox();
        }
    }
}
