package app.gameplay;

import java.util.Random;


public class Gameplay {
    Tools tl = new Tools();

    public int[] start() {
        return tl.getNumber();
    }

    public String general(String num, int[] arr) {
        if (num.equals("0")) {
            return null;
        }
        return tl.check(arr, tl.convertToArr(num));
    } // Проверка на рестарт, если не "0", то играем дальше
}

class Tools {
    int[] getNumber() {
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            int local = getRandomNum();
            if (correctNum(array, local)) {
                array[i] = local;
                System.out.print(local);
            } else {
                i--;
            }
        }
        System.out.print("\n");
        return array;
    }//Компьютер загадал массив

    int getRandomNum() {
        Random rnd = new Random();
        return rnd.nextInt(0, 9);
    } // Генерация случайного числа

    boolean correctNum(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return false;
            }
        }
        return true;
    } // Проверка числа на запись

    String check(int[] userNum, int[] compNum) {
        if (userNum == compNum){
            return "Победа!";
        }
        int cow = 0;
        int bull = 0;
        int empty = 0;
        for (int i = 0; i < compNum.length; i++) {
            if (compNum[i] == userNum[i]) {
                bull++;
                continue; //нашли быков
            } else if (compNum[i] != userNum[i]) {
                for (int j = 0; j < compNum.length; j++) {
                    if (compNum[j] == userNum[i]) {
                        cow++;
                    }
                }
                continue; //нашли коров
            } else {
                empty++;
            }
        }
        return ("Быков: " + bull + " Коров: " + cow);
    } // Результат запроса пользователя

    int[] convertToArr(String numUser) {
        String[] nums = numUser.split("");
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        return arr;
    } // Конвертация строки пользователя
}