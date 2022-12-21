import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<DailyPlanner, Integer> planer = new HashMap<>();
        planer.put(new DailyPlanner("Приготовить обед", "Успеть к обеду", Type.WORKED,
                Repeatability.SINGLE,
                LocalDate.of(2022, 12, 21)), 1);
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            DailyPlanner.inputTask(planer);
                            break;
                        case 2:
                            DailyPlanner.delete(planer);
                            break;
                        case 3:
                            DailyPlanner.getDailyPlan(planer);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу" + '\n' +
                        "2. Удалить задачу" + '\n' +
                        "3. Получить задачу на указанный день" + '\n' +
                        "0. Выход");
    }
}

