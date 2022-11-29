import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                "________________________ Курсовая работа № 2. __________________________");

        HashMap<Integer, Task> taskMaps = new HashMap<>();
//  **********************************************************************************
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                Service.printMenu();
                System.out.print("Выберите задачу и введите № пункта меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:   // Ввод задачи пользователем
                            taskMaps.put(taskMaps.size(),Service.inputTask());
                            break;
                        case 2:   // Удаление задачи пользователем
                            taskMaps.remove(Service.removeTask(scanner));
                            printMap(taskMaps);
                            break;
                        case 3:   // Получение списка задач пользователем на определённую дату
                            LocalDate LD = Service.toGetDateTasks();
                            for (HashMap.Entry<Integer, Task> pair: taskMaps.entrySet()) {
                                if (pair.getValue().isTaskForDate(LD))
                                    System.out.println(pair.getKey() + ": " + pair.getValue());
                            }
                            break;
                        case 4:   // Показать все активные задачи Еженедельника
                            printMap(taskMaps);
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

    } // main -----------------------------------------------------------------

    public static void printMap(HashMap<Integer, Task> taskMaps) {
        System.out.println("\n" + "Список активных задач Ежедневника: ");
        for (HashMap.Entry<Integer, Task> pair: taskMaps.entrySet()) {
            System.out.println("id_" + pair.getKey() + ": " + pair.getValue());
        }
    }
} // Class