package tasksAltarix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by oleg on 20.09.18.
 */
class CategoryB {
    static Scanner in = new Scanner(System.in);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static void task1() {//скобочное выражение
        Stack<String> stack = new Stack<String>(); // Для решения данной задачи нам понадобится стек
        HashSet<String> openingBracket = new HashSet<String>();
        HashSet<String> closingBracket = new HashSet<String>();
        HashMap<String, String> brackets = new HashMap<String, String>();
        String topElem;

        /**
        * инициализируем множества открывающих и закрывающих скобок
        * а так же хэш таблицу устанавливающую соответствие открывающих и закрывающих скобок
        */
        openingBracket.add("(");
        openingBracket.add("[");
        openingBracket.add("{");
        closingBracket.add(")");
        closingBracket.add("]");
        closingBracket.add("}");
        brackets.put("}", "{");//ключи в нашем случае - это закрывающие скобки
        brackets.put("]", "[");
        brackets.put(")", "(");
        System.out.println(openingBracket);
        System.out.println(closingBracket);

        System.out.println("Введите строку со скобками:");
        String string = null;
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(int i = 0; i < string.length(); i++) {//пробегаемся по символам
            if (openingBracket.contains(""+ string.charAt(i) +"")) {
                stack.push(""+ string.charAt(i) +"");//встречая открывающую скобку помещаем ее в стек
            }
            if (closingBracket.contains(""+ string.charAt(i) +"")) {
                if (stack.empty()) {//если нашли закрывающую скобку, и стек пустой, то выражение не верно, дальше не смотрим
                    System.out.println("FAIL");
                    return;
                }
                topElem = String.valueOf(stack.peek());//достаем последний элемент из стека
                if (Objects.equals(topElem, String.valueOf(brackets.get(String.valueOf(string.charAt(i)))))) {//та ли скобка?
                    stack.pop();//если это искомая скобка, достаем крайний элемент из стека
                }
            }
        }
        if (stack.empty()) {//если стек пуст, то скобочное выражение - правильное
            System.out.println("SUCCESS");
        }
        else {//иначе нет
            System.out.println("FAIL");
        }
    }


    static void task2() {//вывод массива
        Random random = new Random();
        System.out.println("Введите размерность матрицы");
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int[] source = new int[n * n];
        for (int i = 0; i < n * n; i++) {// получаем source массив
            source[i] = random.nextInt(100);
        }
        //source = task2TheInsertionSort(source); отказался, тк sort работает ощутимо быстрее
        Arrays.sort(source);//сортируем массив
        int row = 0;
        int col = 0;
        int dx = 1;
        int dy = 0;
        int dirChanges = 0;
        int visits = n;

        for (int i = 0; i < n * n; i++) {//заполняем матрицу
            matrix[row][col] = source[i];
            if (--visits == 0) {
                visits = n * (dirChanges % 2) +
                        n * ((dirChanges + 1) % 2) -
                        (dirChanges / 2 - 1) - 2;
                int temp = dx;
                dx = -dy;
                dy = temp;
                dirChanges++;
            }
            col += dx;
            row += dy;
        }

        for (int i = 0; i < n; i++) {//вывод матрицы
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static int[] task2TheInsertionSort(int[] array) {//алгоритм сортировки прямыми вставками
        int min;//предполагаемый минимальный элемент
        int minI;//индекс предполагаемого минимального элемента
        int help;//вспомогательная переменная
        for (int i = 0; i < array.length; i++){
            min = array[i];
            minI = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minI = j;
                }
            }
            if (i != minI) {
                help = array[i];
                array[i] = array[minI];
                array[minI] = help;
            }

        }
        return array;
    }
}
