import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println(
 "_______________________________ Курсовая работа № 2. ЕЖЕДНЕВНИК _______________________________");
        System.out.println();

        ArrayList<Task> task0 = new ArrayList<>();
        Task mest = new OneOff("Месть", "Дать в фейс соседу за дебош", "Личная", "Одноразовая");
        ArrayList<Task> task1 = new ArrayList<>();
        Task zarydka = new EveryDay("Зарядка","15 минут присяданий, отжиманий и наклонов","Личная", "Ежедневная");
        ArrayList<Task> task2 = new ArrayList<>();
        Task bania = new Weekly("Баня","Моюсь, парюсь, пью пиво", "Личная", "Еженедельная");
        ArrayList<Task> task3 = new ArrayList<>();
        Task salary = new Monthly("Зарплата", "Получить в банке зарплату", "Рабочая", "Ежемесячная");
        ArrayList<Task> task4 = new ArrayList<>();
        Task newYear = new Yearly("Встреча НГ", "Празднуем с семьёй приход НГ", "Личная", "Ежегодная");
        task0.add(mest); task1.add(zarydka); task2.add(bania); task3.add(salary); task4.add(newYear);
        // Вывод: Заполнять конструктор и добавлять в Список можно только в main, Пустой список нужно создать тоже здесь !!!

        HashMap<String, ArrayList<Task>> listHashMap = new HashMap<>();   // было LocalDate стало String
        listHashMap.put("2022-11-24T12:00:00", task0);
        listHashMap.put("2022-11-22T07:00:00", task1);
        listHashMap.put("2022-11-24T10:00:00", task2);
        listHashMap.put("2022-11-15T17:00:00", task3);
        listHashMap.put("2022-11-24T23:00:00", task4);

        for (HashMap.Entry<String, ArrayList<Task>> pair: listHashMap.entrySet()) {
            System.out.println("Object " + pair.getKey() + ": " + pair.getValue());
        }
        System.out.println();

        HashMap<Integer, ArrayList<Task>> taskMaps = new HashMap<>();  // было LocalDate стало String
        taskMaps.put(1, listHashMap.get("2022-11-24T12:00:00"));
        taskMaps.put(2, listHashMap.get("2022-11-22T07:00:00"));
        taskMaps.put(3, listHashMap.get("2022-11-24T10:00:00"));
        taskMaps.put(4, listHashMap.get("2022-11-15T17:00:00"));
        taskMaps.put(5, listHashMap.get("2022-11-24T23:00:00"));

        for (HashMap.Entry<Integer, ArrayList<Task>> pair: taskMaps.entrySet()) {
            System.out.println("Object " + pair.getKey() + ": " + pair.getValue());
        }
        System.out.println();

        TaskMega mestM = new TaskMega(1, listHashMap.get("2022-11-24T12:00:00"));
        TaskMega zarydkaM = new TaskMega(2, listHashMap.get("2022-11-22T07:00:00"));
        TaskMega baniaM = new TaskMega(3, listHashMap.get("2022-11-24T10:00:00"));
        TaskMega salaryM = new TaskMega(4, listHashMap.get("2022-11-15T17:00:00"));
        TaskMega newYearM = new TaskMega(5, listHashMap.get("2022-11-24T23:00:00"));

       startDiary();

   } // main -----------------------------------------------------------------
   public static void startDiary () {
       try (Scanner scanner = new Scanner(System.in)) {
           label:
           while (true) {
               Service.printMenu();
               System.out.print("Выберите задачу и введите № пункта меню: ");
               if (scanner.hasNextInt()) {
                   int menu = scanner.nextInt();
                   switch (menu) {
                       case 1:
                           Service.inputTask(scanner);
                           break;
                       case 2:
                           Service.removeTask(scanner);
                           break;
                       case 3:
                           Service.toGetListTasks(scanner);
                           break;
                       case 0:
                           break label;
                   }
               } else {
                   scanner.next();
                   System.out.println("Выберите задачу и введите № пункта меню: ");
               }
           }
       }

   }
} // Class