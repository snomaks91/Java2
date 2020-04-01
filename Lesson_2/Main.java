package Lesson_2;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        String[][] mas = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mas[i][j] = sc.next();
            }
        }
        System.out.println("Сумма = " + summ(mas));
    }
    public static int summ(String[][] mas) {
        int s = 0;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    try {
                        s = s + Integer.parseInt(mas[i][j]);
                    }catch (Exception e){
                        System.out.println("Координата x" + (i+1));
                        System.out.println("Координата y" + (j+1));
                    }
                }
            }
        return s;
    }
}
