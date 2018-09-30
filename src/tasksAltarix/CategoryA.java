package tasksAltarix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by oleg on 20.09.18.
 */
class CategoryA {
    private static Scanner in = new Scanner(System.in);
    static void task1() { //точка в треугольнике
        HashMap<String, Double> triangular = new HashMap<String, Double>();
        Double A,B,C;//для проверки

        System.out.println("Введите координаты треугольника, координаты точки А:");
        triangular.put("A1", in.nextDouble());
        triangular.put("A2", in.nextDouble());
        System.out.println("Введите координаты точки B:");
        triangular.put("B1", in.nextDouble());
        triangular.put("B2", in.nextDouble());
        System.out.println("Введите координаты точки C:");
        triangular.put("C1", in.nextDouble());
        triangular.put("C2", in.nextDouble());
        System.out.println("Введите координаты точки для проверки принадлежности треугольнику:");
        triangular.put("D1", in.nextDouble());
        triangular.put("D2", in.nextDouble());

        /**
         * формируем три значения для проверки принадлежности точки
         */
        A = (triangular.get("A1") - triangular.get("D1")) * (triangular.get("B2") - triangular.get("A2")) - (triangular.get("B1") - triangular.get("A1")) * (triangular.get("A2") - triangular.get("D2"));
        B = (triangular.get("B1") - triangular.get("D1")) * (triangular.get("C2") - triangular.get("B2")) - (triangular.get("C1") - triangular.get("B1")) * (triangular.get("B2") - triangular.get("D2"));
        C = (triangular.get("C1") - triangular.get("D1")) * (triangular.get("A2") - triangular.get("C2")) - (triangular.get("A1") - triangular.get("C1")) * (triangular.get("C2") - triangular.get("D2"));

        if((A == 0) || (B==0) || (C==0)) { //точка на стороне
            System.out.println("IN");
            return;
        }
        if ((A > 0) && (B > 0) && (C > 0)) {//если A B и C одного знака, то точка лежит в треугольнике
            System.out.println("IN");
            return;
        }
        if ((A < 0) && (B < 0) && (C < 0)) {
            System.out.println("IN");
            return;
        }
        System.out.println("OUT"); // ни одно из условий не дало истину => точка вне треугольника
    }

    static void task2() { // модуль разности сумм диагоналей
        BufferedReader matrRead = new BufferedReader(new InputStreamReader(System.in));
        Double diagonal1 = 0.0;
        Double diagonal2 = 0.0;
        Double matrElem = 0.0;
        Double res = 0.0;
        int n;

        System.out.println("Введите размерность матрицы");
        n = in.nextInt();
        System.out.println("Введите поэлементно матрицу");
        for (int i = 0; i < n; i++) { //заполнение матрицы
            for (int j = 0; j < n; j++) {
                try {
                    matrElem = Double.parseDouble(matrRead.readLine());
                    if (i == j) {// первая диагональ
                        diagonal1 += matrElem;
                    }
                    if (i + j == n-1) { //вторая диагональ
                        diagonal2 += matrElem;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        res = diagonal1 - diagonal2; // считаем разницу диагоналей
        System.out.printf("Разница диагонаоей = ");
        System.out.println(Math.abs(res)); // вывод абсолютной величины
    }

    static void task3() {// лестница
        System.out.println("Введите высоту лестницы");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("#");
            }
            System.out.println();
        }
    }

    static void task4() { //поиск пар
        System.out.println("введите размерность массива:");
        int n = in.nextInt();
        if (n < 0){
            System.out.println("Ошибка! размерность массива не может быть меньше 1");
            return;
        }
        System.out.println("Введите число K");
        int k = in.nextInt();
        int flag = 0;
        int pair = 0;
        int[] mass = new int[n];

        System.out.println("введите поочередно элементы массива");
        for (int i = 0; i < n; i++) {
            mass[i] = in.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {// проходим массив
            for (int j = i + 1; j < n; j++) { // каждый проход начинается с текущего эл-та, помним, что i<j
                flag = mass[i] + mass[j];//фиксируем сумму пары
                if (flag % k == 0) {//остаток от деления = 0 => пара найдена
                    pair += 1;
                }
            }
        }

        System.out.println("Кол-во искомых пар = " + pair);
    }

}
