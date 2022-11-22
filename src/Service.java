import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Service {


     // п.1 Меню: Добавить задачу......................................................
    public static void inputTask(Scanner scanner) {  // Ввод задачи пользователем.

        String taskName = scanner.nextLine();
//        Task.setTaskName(scanner.nextLine());
        System.out.print("Введите описание задачи: ");
        String descript = scanner.nextLine();
//        Task.setDescript(scanner.nextLine());
        // передать параметр в Мапу..................


//        Task.setType(defineType(scanner));
        defineType(scanner);
//        Task.setDataActivity(defineDateTime(scanner));
//        Task.setPeriodicity(definePeriodicity(scanner));
        defineDateTime(scanner);
        definePeriodicity(scanner);

        System.out.println("ПЕЧАТАЕМ ВВЕДЕННУЮ МАПУ...");
//        System.out.println("Задача №" + Task.id + ". Активация "+ Task.dataActivity + " " + Task.taskName + ": " +
//                Task.descript + ", тип - " + Task.type + ", периодичность - " + Task.periodicity + ".");

    }
    public static void printMenu() {
        System.out.println("1. Добавить задачу" + "\n"
                + "2. Удалить задачу" + "\n"
                + "3. Получить задачи на указанный день" + "\n"
                + "0. Выход");
    }
    public static String defineType(Scanner scanner) {
        System.out.print("Выберите тип задачи или введите № пункта меню: " + "\n"
                + "1. Личная" + "\n" + "2. Рабочая" + "\n");
        String type = scanner.nextLine();
        if ( type.equals("1") || type.equals("Личная")) {
            type = "Личная";
        } else if (type.equals("2") || type.equals("Рабочая")) {
            type = "Рабочая";
        } else {
            //    throw new RuntimeException("Тип задачи введен не верно! Повторите.");
            System.out.println("Тип задачи введен не верно! Повторите всё снова.");
            defineType(scanner);
            //Main.startDiary();
        }
        System.out.println("Тип задачи: " + type);
        return type;
    }
    public static LocalDateTime defineDateTime(Scanner scanner) {
        System.out.print("Введите дату и время 1-й активации задачи (в формате yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime dateActivity = LocalDateTime.parse(scanner.nextLine());

        // Как обработать ошибку ввода с отсылом на старт этого метода ?

        System.out.println("Дата и время активации задачи: " + dateActivity);
        return dateActivity;
    }
    public static String definePeriodicity(Scanner scanner) {
        String periodicity;
        System.out.print("Выберите периодичность задачи и введите № меню: " + "\n"
                + "1. Однократная" + "\n"
                + "2. Ежедневная" + "\n"
                + "3. Еженедельная" + "\n"
                + "4. Ежемесячная" + "\n"
                + "5. Ежегодная" + "\n" );
        String repeatability = scanner.nextLine();
        switch (repeatability) {
            case "1":
                periodicity = "Однократная";
                // передать параметр в Мапу..................
                System.out.println("Периодичность задачи: " + periodicity + "\n" );

                //break;
                return periodicity;
            case "2":
                periodicity = "Ежедневная";
                // передать параметр в Мапу..................
                System.out.println("Периодичность задачи: " + periodicity + "\n" );
                //break;
                return periodicity;
            case "3":
                periodicity = "Еженедельная";
                // передать параметр в Мапу..................
                System.out.println("Периодичность задачи: " + periodicity + "\n" );
                //break;
                return periodicity;
            case "4":
                periodicity = "Ежемесячная";
                // передать параметр в Мапу..................
                System.out.println("Периодичность задачи: " + periodicity + "\n" );
                //break;
                return periodicity;
            case "5":
                periodicity = "Ежегодная";
                // передать параметр в Мапу..................
                System.out.println("Периодичность задачи: " + periodicity + "\n" );
                //break;
                return periodicity;
            default:
                throw new RuntimeException("Периодичность задачи введен не верно! Повторите.");
//                System.out.println("Периодичность задачи введен не верно! Повторите всё снова.");
//                tmp(scanner);
        }
    }

    // п.2 Меню: Удаление задачи по ID.........................................................
    public static void removeTask(Scanner scanner) {  // Удаление задачи пользователем.
        System.out.print("Введите id задачи для её удаления: ");
        int idTmp = scanner.nextInt();
        // Цикл перебора Мапы, поиска по id == idTmp и удаления задачи......................
        System.out.println("Задача с id " + idTmp + " удалена из Ежедневника." + "\n" );

    }

    // п.3 Меню: Получить задачи на указанный день .............................................
    public static void toGetListTasks(Scanner scanner) {  // Получение списка задачи на заданную дату.
        System.out.print("Введите дату (yyyy-MM-dd) для получения на неё списка задач: ");
        LocalDate localDate = LocalDate.parse(scanner.nextLine());
        // ДАЁТ ОШИБКУ ПРИ ПЕРЕВОДЕ СТРОКИ В ФОРМАТ ДАТЫ !!!
        // Цикл перебора Мапы, поиска по localDate задач и вывод списка......................
    }
    public static void tmp(Scanner scanner) {
        definePeriodicity(scanner);
    }

//******************************************************************************************


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
} // Class -----------------------------------------------------------------------
