package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public static class Game {
        public void startGame() {
        }
    }

    public static class Gra {
        private static final ArrayList<Player> MOVES_QUEUE = new ArrayList<>();

        private static final int BOARD_SIZE = 3;
        private static final char X = 'X';
        private static final char O = 'O';
        private static final char EMPTY = ' ';

        private static final String VERTICAL = "\u2502";
        private static final String HORIZONTAL = "\u2500";
        private static final String TRIPLE_HORIZONTAL = HORIZONTAL + HORIZONTAL + HORIZONTAL;
        private static final String CROSS = "\u253C";

        private static final int BINARY_11 = 3;
        private static final int BINARY_01 = 1;

        private static int GAME_STATE = 0b0;

        private Player winner;

        public void startGame() {
            generateMovesQueue();
            System.out.println(MOVES_QUEUE.get(0) + " starts!");

            refreshBoard();
            for (int i = 0; ((i < 9)); i++) {
                Player player = MOVES_QUEUE.get(i);

                boolean ok = false;
                String inputIndex;
                while (!ok) {
                    System.out.print(player + " chooses index: ");
                    Scanner scanner = new Scanner(System.in);
                    inputIndex = scanner.nextLine();

                    if (isIndexValid(inputIndex)) {
                        makeMove(player, (Integer.parseInt(inputIndex) - 1));
                        ok = true;
                    } else {
                        System.out.print("Invalid input or index is already taken!");
                    }
                    System.out.println();
                }
                refreshBoard();
                if (isGameWon()) {
                    winner = player;
                    break;
                }
            }

            if (winner == null) {
                System.out.println("Game ended with a draw");
            } else {
                System.out.println("*** " + winner + " won! ***");
            }
            System.out.println("GG!");
        }

        public boolean isGameWon() {
            /** Check for win in rows */
            /*
            for (int i = 0; i < 3; i++) {
                int rowValue1 = (GAME_STATE >> ((i * 3) * 2)) & (BINARY_11);
                int rowValue2 = (GAME_STATE >> ((i * 3 + 1) * 2)) & (BINARY_11);
                int rowValue3 = (GAME_STATE >> ((i * 3 + 1) * 2)) & (BINARY_11);

                if (rowValue1 != 0
                        && rowValue1 == rowValue2
                        && rowValue1 == rowValue3
                ) {
                    return true;
                }
            }
            */

            return false;
        }

        private boolean isIndexValid(String inputIndex) {
            try {
                int index = Integer.parseInt(inputIndex) - 1;
                int checkValue = BINARY_11 << (index * 2);
                return ((GAME_STATE & checkValue) == 0) && index <= 9;
            } catch (Exception ex) {
                return false;
            }
        }

        public void makeMove(Player player, int index) {
            int player_binary_value;
            if (player == Player.X) {
                player_binary_value = BINARY_11;
            } else {
                player_binary_value = BINARY_01;
            }

            int operationResult = player_binary_value << (index * 2);

            GAME_STATE = GAME_STATE | operationResult;
        }

        public void refreshBoard() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {

                    int shiftValue = (i * BOARD_SIZE + j) * 2;
                    char value;

                    int operationResult = (GAME_STATE >> shiftValue) & BINARY_11;

                    if (operationResult == 3) {
                        value = X;
                    } else if (operationResult == 2 || operationResult == 1) {
                        value = O;
                    } else {
                        value = EMPTY;
                    }

                    System.out.print(" " + value + " ");
                    if (j != BOARD_SIZE - 1) {
                        System.out.print(VERTICAL);
                    }
                }
                System.out.println();
                if ((i != BOARD_SIZE - 1)) {
                    System.out.println(TRIPLE_HORIZONTAL + CROSS + TRIPLE_HORIZONTAL + CROSS + TRIPLE_HORIZONTAL);
                }
            }
        }

        public void generateMovesQueue() {
            int randomBinaryNumber = ((int) (Math.random() * 2));
            Player odd;
            Player even;
            if (randomBinaryNumber == 0) {
                odd = Player.O;
                even = Player.X;
            } else {
                odd = Player.X;
                even = Player.O;
            }
            for (int i = 0; i < 9; i++) {
                MOVES_QUEUE.add((i % 2 == 0) ? odd : even);
            }
        }

    }

    public enum Player {
        X,
        O,
    }
}

