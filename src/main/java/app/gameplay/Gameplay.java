package app.gameplay;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    Tools tl = new Tools();
    public int [] start(){
        return tl.getNumber();
    }
    public String general(String num, int [] arr) {
        return tl.check(arr, tl.convertToArr(num));
    }
}
class Tools {
    int [] getNumber (){
        int [] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            int local = getRandomNum();
            if (correctNum(array, local)){
                array[i] = local;
                System.out.print(local);
            }
            else{
                i--;
            }
        }
        return array;
    }//Компьютер загадал
    int getRandomNum(){
        Random rnd = new Random();
        return rnd.nextInt(0,9);
    } // генерация случайного числа
    boolean correctNum(int [] array, int val){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val){
                return false;
            }
        }
        return true;
    } // Запись числа
    String check(int [] userNum, int [] compNum ){
        int cow = 0;
        int bull = 0;
        int empty = 0;
        for (int i = 0; i < compNum.length; i++) {
            if (compNum[i] == userNum[i]){
                bull++;
                continue;
            }
            else if (compNum[i] != userNum[i]){
                for (int j = 0; j < compNum.length; j++) {
                    if (compNum[j] == userNum[i]){
                        cow++;
                    }
                }
                continue;
            }
            else {
                empty++;
            }
        }
        return ("Быков: " + bull + " Коров: " + cow);
    }
    int [] convertToArr(String numUser){
        String [] nums = numUser.split("");
        int [] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        return arr;
    }
}