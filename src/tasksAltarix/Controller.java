package tasksAltarix;

import com.sun.org.apache.xpath.internal.SourceTree;
import tasksAltarix.CategoryA.*;
import tasksAltarix.CategoryB.*;
import tasksAltarix.CategoryC.*;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by oleg on 23.09.18.
 */
/**
* Этот класс для запуска заданий
* */
class Controller {
    public static void main(String[] args) {
        String category;
        String number;
        String task;

        HashSet<String> tasksPattern = new HashSet<String>();
        tasksPattern = tasksAdd(tasksPattern);

        Scanner in = new Scanner(System.in);

        System.out.println("Введите категорию сложности (a, b, c):");
        category = in.next();
        System.out.println("Введите номер задания (1..5):");
        number = in.next();
        task = category.toUpperCase() + number;

        if (!tasksPattern.contains(task)) { // проверка существования таска
            System.out.println("Такого таска нет");
        }
        else {
            taskStart(task); //запуск таска
        }

    }

    private static HashSet<String> tasksAdd(HashSet<String> tasksPattern) { //создаем множество содержащее все таски
        tasksPattern.add("A1");
        tasksPattern.add("A2");
        tasksPattern.add("A3");
        tasksPattern.add("A4");
        tasksPattern.add("A5");
        tasksPattern.add("B1");
        tasksPattern.add("B2");
        tasksPattern.add("B3");
        tasksPattern.add("C1");
        return tasksPattern;
    }

    private static void taskStart(String task) {//запуск таска, вынес для читаемости
        switch (task) {
            case "A1":
                CategoryA.task1();
                break;
            case "A2":
                CategoryA.task2();
                break;
            case "A3":
                CategoryA.task3();
                break;
            case "A4":
                CategoryA.task4();
                break;
            case "A5":
                CategoryA.task1();
                break;
            case "B1":
                CategoryB.task1();
                break;
            case "B2":
                CategoryB.task2();
                break;
            case "B3":
                CategoryA.task1();
                break;
            case "C1":
                CategoryA.task1();
                break;
        }
    }
}
