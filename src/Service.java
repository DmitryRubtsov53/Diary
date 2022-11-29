import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Service {

    private final static DateTimeFormatter TASK_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final static DateTimeFormatter LIST_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // п.1 Меню: Добавить задачу......................................................
    public static void printMenu() {
        System.out.println("\n" + "-------- ЕЖЕДНЕВНИК. ГЛАВНОЕ МЕНЮ -----------" +"\n"
                + "1. Добавить задачу." + "\n"
                + "2. Удалить задачу." + "\n"
                + "3. Получить задачи на указанный день." + "\n"
                + "4. Показать все задачи Еженедельника." + "\n"
                + "0. ВЫХОД из приложения.");
    }
    public static Task inputTask() {  // Ввод задачи пользователем.
        Scanner scanner = new Scanner(System.in);

        String taskName = enterName(),
                description = enterDescript(),
                type = defineType(),
                periodicity = definePeriodicity(scanner);
        LocalDateTime dateActivity = defineDateTime(scanner);

        switch (periodicity) {
            case "1":
                return new OneOff(taskName, description, type, dateActivity, "Однократная");
            case "2":
                return new EveryDay(taskName, description, type, dateActivity, "Ежедневная");
            case "3":
                return new Weekly(taskName, description, type, dateActivity, "Еженедельная");
            case "4":
                return new Monthly(taskName, description, type, dateActivity, "Ежемесячная");
            case "5":
                return new Yearly(taskName, description, type, dateActivity, "Ежегодная");
            default:
                return new Yearly("Винтовка", " рождает", " власть!",
                        null, "@ Мао Дзэдун.");
        }
    }
    public static String enterDescript() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите описание задачи: ");
                String descript = scanner.nextLine();
                System.out.println("----------------------------------------------");
                if (descript != null || !descript.isBlank())
                    return descript;
            } catch (Exception e) {
                System.out.println("Название задачи введено не корректно! Повторите ввод.");
            }
        }
    }
    public static String enterName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите название задачи: ");
                String taskName = scanner.nextLine();
                if (taskName != null || !taskName.isBlank())
                    return taskName;
            } catch (Exception e) {
                System.out.println("Название задачи введено не корректно! Повторите ввод.");
            }
        }
    }
    public static String defineType() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print( "1. Личная" + "\n" + "2. Рабочая" + "\n" +
                    "Выберите тип задачи и введите № пункта меню: ");
            String type = scanner.nextLine();
            System.out.println("----------------------------------------------");
            switch (type) {
                case "1":
                    return "Личная";
                case "2":
                    return "Рабочая";
                default:
                    System.out.println("Тип задачи введен не верно! Повторите ввод.");
                    break;
            }
        }
    }
    public static String definePeriodicity(Scanner scanner) {
        while (true) {
            //String periodicity;
            System.out.print("1. Однократная" + "\n"
                    + "2. Ежедневная" + "\n"
                    + "3. Еженедельная" + "\n"
                    + "4. Ежемесячная" + "\n"
                    + "5. Ежегодная" + "\n"
                    + "Выберите периодичность задачи и введите № пункта меню: ");
            String period = scanner.nextLine();
            System.out.println("----------------------------------------------");

            switch (period) {
                case "1": return "1";
                case "2": return "2";
                case "3": return "3";
                case "4": return "4";
                case "5": return "5";
                default:
                    System.out.println("Периодичность задачи введен не верно! Повторите ввод.");
                    break;
            }
        }
    }
    // п.2 Меню: Удаление задачи по ID.........................................................
    public static int removeTask(Scanner scanner) {  // Удаление задачи пользователем.
        System.out.print("Введите id задачи для её удаления: ");
        int idTmp = scanner.nextInt();
        System.out.println("Задача с id " + idTmp + " удалена из Ежедневника." + "\n" );
        return idTmp;
    }
    public static LocalDateTime defineDateTime(Scanner scanner) {  // Получаем дату АКТИВАЦИИ задачи.
        while (true) {
            try {
                System.out.print("Введите дату и время АКТИВАЦИИ задачи (в формате dd.MM.yyyy HH:mm): ");
                String dateActivity = scanner.nextLine();
                System.out.println("----------------------------------------------");
                return LocalDateTime.parse(dateActivity, TASK_DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Ведены не правильно дата и время! Повторите ввод.");
            }
        }
    }
    // п.3 Меню: Получить задачи на указанный день ......... ....................................
    public static LocalDate toGetDateTasks() {  // Получение даты списка задач.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дату (в формате dd.MM.yyyy) для получения списка задач: ");
                String localDate = scanner.nextLine();
                return LocalDate.parse(localDate, LIST_DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Дата введена не правильно! Повторите ввод.");
            }
        }
    } //.........................................................................................

} // Class