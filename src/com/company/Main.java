package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static final int dimension = 3; //размерность игрового поля
    static String[][] field = new String[dimension][dimension]; //игровое поле
    static String inputChoice; //делаем выбор играть за крестики или за нолики
    static int firstCoord; //первая координата, которую вводит юзер
    static int secondCoord; //вторая координата, которую вводит юзер
    static int firstCoordComputer; //первая координата, которую вводит компьютер
    static int secondCoordComputer; //вторая координата, которую вводит компьютер
    static String dot; //переменная, запоминающая Х или 0
    static int count; //переменная для проверки заполненности поля


    //функция, выводящая игровое поле
    public static void outputTicTacToe() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println(" ");
        }
    }

    //функция, заполняющая игровое поле
    public static void fillTicTacToe() {
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
                field[i][j] = "[ ]";
            }
        }
    }

    //функция, реализующая игровые механики
    public static void letsPlayTicTacToe() {
        switch (inputChoice) {
            case "X": {
                while (true) {
                    //ход игрока за крестики
                    System.out.println("Выберите клетку");
                    System.out.print("Введите первую координату: ");
                    firstCoord = input.nextInt();
                    System.out.print("Введите вторую координату: ");
                    secondCoord = input.nextInt();
                    while (field[firstCoord][secondCoord] == "[X]" || field[firstCoord][secondCoord] == "[0]") {
                        System.out.println("Клетка заполнена! Введите коордианты снова");
                        System.out.print("Введите первую координату: ");
                        firstCoord = input.nextInt();
                        System.out.print("Введите вторую координату: ");
                        secondCoord = input.nextInt();
                    }
                    field[firstCoord][secondCoord] = "[X]";
                    dot = "[X]";
                    for (int i = 0; i < dimension; i++) {
                        if ((field[i][0] == dot && field[i][1] == dot && field[i][2] == dot)
                                || (field[0][i] == dot && field[1][i] == dot && field[2][i] == dot)) {
                            outputTicTacToe();
                            System.out.println("Вы выйграли!");
                            return;
                        }
                        if ((field[0][0] == dot && field[1][1] == dot &&
                                field[2][2] == dot) ||
                                (field[2][0] == dot && field[1][1] == dot &&
                                        field[0][2] == dot)) {
                            outputTicTacToe();
                            System.out.println("Вы выйграли!");
                            return;
                        }
                    }
                    count = 0;

                    //проверяем, заполнено ли поле
                    for (int i = 0; i < dimension; i++) {
                        for (int j = 0; j < dimension; j++) {
                            if (field[i][j] != "[ ]")
                                count++;
                        }
                    }
                    if (count == 9) {
                        outputTicTacToe();
                        System.out.println("Ничья!");
                        return;
                    }
                    outputTicTacToe();
                    System.out.println(" ");

                    //ход компьютера за нолики
                    System.out.println("Ход компьютера");
                    firstCoordComputer = rand.nextInt(field.length);
                    secondCoordComputer = rand.nextInt(field.length);
                    while (field[firstCoordComputer][secondCoordComputer] == "[X]" || field[firstCoordComputer][secondCoordComputer] == "[0]") {
                        firstCoordComputer = rand.nextInt(field.length);
                        secondCoordComputer = rand.nextInt(field.length);
                    }
                    field[firstCoordComputer][secondCoordComputer] = "[0]";
                    dot = "[0]";
                    for (int i = 0; i < dimension; i++) {
                        if ((field[i][0] == dot && field[i][1] == dot && field[i][2] == dot)
                                || (field[0][i] == dot && field[1][i] == dot && field[2][i] == dot)) {
                            outputTicTacToe();
                            System.out.println("Компьютер выйграл!");
                            return;
                        }
                        if ((field[0][0] == dot && field[1][1] == dot &&
                                field[2][2] == dot) ||
                                (field[2][0] == dot && field[1][1] == dot &&
                                        field[0][2] == dot)) {
                            outputTicTacToe();
                            System.out.println("Компьютер выйграл!");
                            return;
                        }
                    }
                    count = 0;

                    //проверяем, заполнено ли поле
                    for (int i = 0; i < dimension; i++) {
                        for (int j = 0; j < dimension; j++) {
                            if (field[i][j] != "[ ]")
                                count++;
                        }
                    }
                    if (count == 9) {
                        outputTicTacToe();
                        System.out.println("Ничья!");
                        return;
                    }
                    outputTicTacToe();
                    System.out.println(" ");
                }
            }
            case "0": {
                while (true) {
                    //ход компьютера за крестики
                    System.out.println("Ход компьютера");
                    firstCoordComputer = rand.nextInt(field.length);
                    secondCoordComputer = rand.nextInt(field.length);
                    while (field[firstCoordComputer][secondCoordComputer] == "[X]" || field[firstCoordComputer][secondCoordComputer] == "[0]") {
                        firstCoordComputer = rand.nextInt(field.length);
                        secondCoordComputer = rand.nextInt(field.length);
                    }
                    field[firstCoordComputer][secondCoordComputer] = "[X]";
                    dot = "[X]";
                    for (int i = 0; i < dimension; i++) {
                        if ((field[i][0] == dot && field[i][1] == dot && field[i][2] == dot)
                                || (field[0][i] == dot && field[1][i] == dot && field[2][i] == dot)) {
                            outputTicTacToe();
                            System.out.println("Компьютер выйграл!");
                            return;
                        }
                        if ((field[0][0] == dot && field[1][1] == dot &&
                                field[2][2] == dot) ||
                                (field[2][0] == dot && field[1][1] == dot &&
                                        field[0][2] == dot)) {
                            outputTicTacToe();
                            System.out.println("Компьютер выйграл!");
                            return;
                        }
                    }
                    count = 0;

                    //проверяем, заполнено ли поле
                    for (int i = 0; i < dimension; i++) {
                        for (int j = 0; j < dimension; j++) {
                            if (field[i][j] != "[ ]")
                                count++;
                        }
                    }
                    if (count == 9) {
                        outputTicTacToe();
                        System.out.println("Ничья!");
                        return;
                    }
                    outputTicTacToe();
                    System.out.println(" ");

                    //ход игрока за нолики
                    System.out.println("Выберите клетку");
                    System.out.print("Введите первую координату: ");
                    firstCoord = input.nextInt();
                    System.out.print("Введите вторую координату: ");
                    secondCoord = input.nextInt();
                    while (field[firstCoord][secondCoord] == "[X]" || field[firstCoord][secondCoord] == "[0]") {
                        System.out.println("Клетка заполнена! Введите коордианты снова");
                        System.out.print("Введите первую координату: ");
                        firstCoord = input.nextInt();
                        System.out.print("Введите вторую координату: ");
                        secondCoord = input.nextInt();
                    }
                    field[firstCoord][secondCoord] = "[0]";
                    dot = "[0]";
                    for (int i = 0; i < dimension; i++) {
                        if ((field[i][0] == dot && field[i][1] == dot && field[i][2] == dot)
                                || (field[0][i] == dot && field[1][i] == dot && field[2][i] == dot)) {
                            outputTicTacToe();
                            System.out.println("Вы выйграли!");
                            return;
                        }
                        if ((field[0][0] == dot && field[1][1] == dot &&
                                field[2][2] == dot) ||
                                (field[2][0] == dot && field[1][1] == dot &&
                                        field[0][2] == dot)) {
                            outputTicTacToe();
                            System.out.println("Вы выйграли!");
                            return;
                        }
                    }
                    count = 0;

                    //проверяем, заполнено ли поле
                    for (int i = 0; i < dimension; i++) {
                        for (int j = 0; j < dimension; j++) {
                            if (field[i][j] != "[ ]")
                                count++;
                        }
                    }
                    if (count == 9) {
                        outputTicTacToe();
                        System.out.println("Ничья!");
                        return;
                    }
                    outputTicTacToe();
                    System.out.println(" ");
                }
            }
            default: {
                System.out.println("Неверно введен выбор! Попробуйте снова");
                inputChoice = input.nextLine();
                letsPlayTicTacToe();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Это крестики-нолики! Напишите 'X', если хотите начать с крестиков или '0', если хотите начать с ноликов");
        fillTicTacToe();
        inputChoice = input.nextLine();
        letsPlayTicTacToe();
    }
}